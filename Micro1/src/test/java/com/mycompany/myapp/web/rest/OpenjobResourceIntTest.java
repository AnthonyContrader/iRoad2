package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.Micro1App;

import com.mycompany.myapp.domain.Openjob;
import com.mycompany.myapp.repository.OpenjobRepository;
import com.mycompany.myapp.service.OpenjobService;
import com.mycompany.myapp.service.dto.OpenjobDTO;
import com.mycompany.myapp.service.mapper.OpenjobMapper;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the OpenjobResource REST controller.
 *
 * @see OpenjobResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class OpenjobResourceIntTest {

    private static final String DEFAULT_TITOLO = "AAAAAAAAAA";
    private static final String UPDATED_TITOLO = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIZIONE = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIZIONE = "BBBBBBBBBB";

    private static final String DEFAULT_REQUISITI = "AAAAAAAAAA";
    private static final String UPDATED_REQUISITI = "BBBBBBBBBB";

    @Autowired
    private OpenjobRepository openjobRepository;


    @Autowired
    private OpenjobMapper openjobMapper;
    

    @Autowired
    private OpenjobService openjobService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restOpenjobMockMvc;

    private Openjob openjob;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final OpenjobResource openjobResource = new OpenjobResource(openjobService);
        this.restOpenjobMockMvc = MockMvcBuilders.standaloneSetup(openjobResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Openjob createEntity(EntityManager em) {
        Openjob openjob = new Openjob()
            .titolo(DEFAULT_TITOLO)
            .descrizione(DEFAULT_DESCRIZIONE)
            .requisiti(DEFAULT_REQUISITI);
        return openjob;
    }

    @Before
    public void initTest() {
        openjob = createEntity(em);
    }

    @Test
    @Transactional
    public void createOpenjob() throws Exception {
        int databaseSizeBeforeCreate = openjobRepository.findAll().size();

        // Create the Openjob
        OpenjobDTO openjobDTO = openjobMapper.toDto(openjob);
        restOpenjobMockMvc.perform(post("/api/openjobs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(openjobDTO)))
            .andExpect(status().isCreated());

        // Validate the Openjob in the database
        List<Openjob> openjobList = openjobRepository.findAll();
        assertThat(openjobList).hasSize(databaseSizeBeforeCreate + 1);
        Openjob testOpenjob = openjobList.get(openjobList.size() - 1);
        assertThat(testOpenjob.getTitolo()).isEqualTo(DEFAULT_TITOLO);
        assertThat(testOpenjob.getDescrizione()).isEqualTo(DEFAULT_DESCRIZIONE);
        assertThat(testOpenjob.getRequisiti()).isEqualTo(DEFAULT_REQUISITI);
    }

    @Test
    @Transactional
    public void createOpenjobWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = openjobRepository.findAll().size();

        // Create the Openjob with an existing ID
        openjob.setId(1L);
        OpenjobDTO openjobDTO = openjobMapper.toDto(openjob);

        // An entity with an existing ID cannot be created, so this API call must fail
        restOpenjobMockMvc.perform(post("/api/openjobs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(openjobDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Openjob in the database
        List<Openjob> openjobList = openjobRepository.findAll();
        assertThat(openjobList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllOpenjobs() throws Exception {
        // Initialize the database
        openjobRepository.saveAndFlush(openjob);

        // Get all the openjobList
        restOpenjobMockMvc.perform(get("/api/openjobs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(openjob.getId().intValue())))
            .andExpect(jsonPath("$.[*].titolo").value(hasItem(DEFAULT_TITOLO.toString())))
            .andExpect(jsonPath("$.[*].descrizione").value(hasItem(DEFAULT_DESCRIZIONE.toString())))
            .andExpect(jsonPath("$.[*].requisiti").value(hasItem(DEFAULT_REQUISITI.toString())));
    }
    

    @Test
    @Transactional
    public void getOpenjob() throws Exception {
        // Initialize the database
        openjobRepository.saveAndFlush(openjob);

        // Get the openjob
        restOpenjobMockMvc.perform(get("/api/openjobs/{id}", openjob.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(openjob.getId().intValue()))
            .andExpect(jsonPath("$.titolo").value(DEFAULT_TITOLO.toString()))
            .andExpect(jsonPath("$.descrizione").value(DEFAULT_DESCRIZIONE.toString()))
            .andExpect(jsonPath("$.requisiti").value(DEFAULT_REQUISITI.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingOpenjob() throws Exception {
        // Get the openjob
        restOpenjobMockMvc.perform(get("/api/openjobs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOpenjob() throws Exception {
        // Initialize the database
        openjobRepository.saveAndFlush(openjob);

        int databaseSizeBeforeUpdate = openjobRepository.findAll().size();

        // Update the openjob
        Openjob updatedOpenjob = openjobRepository.findById(openjob.getId()).get();
        // Disconnect from session so that the updates on updatedOpenjob are not directly saved in db
        em.detach(updatedOpenjob);
        updatedOpenjob
            .titolo(UPDATED_TITOLO)
            .descrizione(UPDATED_DESCRIZIONE)
            .requisiti(UPDATED_REQUISITI);
        OpenjobDTO openjobDTO = openjobMapper.toDto(updatedOpenjob);

        restOpenjobMockMvc.perform(put("/api/openjobs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(openjobDTO)))
            .andExpect(status().isOk());

        // Validate the Openjob in the database
        List<Openjob> openjobList = openjobRepository.findAll();
        assertThat(openjobList).hasSize(databaseSizeBeforeUpdate);
        Openjob testOpenjob = openjobList.get(openjobList.size() - 1);
        assertThat(testOpenjob.getTitolo()).isEqualTo(UPDATED_TITOLO);
        assertThat(testOpenjob.getDescrizione()).isEqualTo(UPDATED_DESCRIZIONE);
        assertThat(testOpenjob.getRequisiti()).isEqualTo(UPDATED_REQUISITI);
    }

    @Test
    @Transactional
    public void updateNonExistingOpenjob() throws Exception {
        int databaseSizeBeforeUpdate = openjobRepository.findAll().size();

        // Create the Openjob
        OpenjobDTO openjobDTO = openjobMapper.toDto(openjob);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restOpenjobMockMvc.perform(put("/api/openjobs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(openjobDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Openjob in the database
        List<Openjob> openjobList = openjobRepository.findAll();
        assertThat(openjobList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteOpenjob() throws Exception {
        // Initialize the database
        openjobRepository.saveAndFlush(openjob);

        int databaseSizeBeforeDelete = openjobRepository.findAll().size();

        // Get the openjob
        restOpenjobMockMvc.perform(delete("/api/openjobs/{id}", openjob.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Openjob> openjobList = openjobRepository.findAll();
        assertThat(openjobList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Openjob.class);
        Openjob openjob1 = new Openjob();
        openjob1.setId(1L);
        Openjob openjob2 = new Openjob();
        openjob2.setId(openjob1.getId());
        assertThat(openjob1).isEqualTo(openjob2);
        openjob2.setId(2L);
        assertThat(openjob1).isNotEqualTo(openjob2);
        openjob1.setId(null);
        assertThat(openjob1).isNotEqualTo(openjob2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(OpenjobDTO.class);
        OpenjobDTO openjobDTO1 = new OpenjobDTO();
        openjobDTO1.setId(1L);
        OpenjobDTO openjobDTO2 = new OpenjobDTO();
        assertThat(openjobDTO1).isNotEqualTo(openjobDTO2);
        openjobDTO2.setId(openjobDTO1.getId());
        assertThat(openjobDTO1).isEqualTo(openjobDTO2);
        openjobDTO2.setId(2L);
        assertThat(openjobDTO1).isNotEqualTo(openjobDTO2);
        openjobDTO1.setId(null);
        assertThat(openjobDTO1).isNotEqualTo(openjobDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(openjobMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(openjobMapper.fromId(null)).isNull();
    }
}
