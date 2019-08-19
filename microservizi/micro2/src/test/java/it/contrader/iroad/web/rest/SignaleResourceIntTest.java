package it.contrader.iroad.web.rest;

import it.contrader.iroad.Micro2App;

import it.contrader.iroad.domain.Signale;
import it.contrader.iroad.domain.Street;
import it.contrader.iroad.repository.SignaleRepository;
import it.contrader.iroad.service.SignaleService;
import it.contrader.iroad.service.dto.SignaleDTO;
import it.contrader.iroad.service.mapper.SignaleMapper;
import it.contrader.iroad.web.rest.errors.ExceptionTranslator;

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


import static it.contrader.iroad.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import it.contrader.iroad.domain.enumeration.SignaleType;
/**
 * Test class for the SignaleResource REST controller.
 *
 * @see SignaleResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class SignaleResourceIntTest {

    private static final SignaleType DEFAULT_SIGNALE_TYPE = SignaleType.STOP;
    private static final SignaleType UPDATED_SIGNALE_TYPE = SignaleType.SEMAFORO;

    private static final String DEFAULT_SIGNALE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SIGNALE_NAME = "BBBBBBBBBB";

    private static final Float DEFAULT_LONG_SIGNALE = 1F;
    private static final Float UPDATED_LONG_SIGNALE = 2F;

    private static final Float DEFAULT_LAT_SIGNALE = 1F;
    private static final Float UPDATED_LAT_SIGNALE = 2F;

    @Autowired
    private SignaleRepository signaleRepository;


    @Autowired
    private SignaleMapper signaleMapper;
    

    @Autowired
    private SignaleService signaleService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSignaleMockMvc;

    private Signale signale;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SignaleResource signaleResource = new SignaleResource(signaleService);
        this.restSignaleMockMvc = MockMvcBuilders.standaloneSetup(signaleResource)
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
    public static Signale createEntity(EntityManager em) {
        Signale signale = new Signale()
            .signaleType(DEFAULT_SIGNALE_TYPE)
            .signaleName(DEFAULT_SIGNALE_NAME)
            .longSignale(DEFAULT_LONG_SIGNALE)
            .latSignale(DEFAULT_LAT_SIGNALE);
        // Add required entity
        Street street = StreetResourceIntTest.createEntity(em);
        em.persist(street);
        em.flush();
        signale.setStreet(street);
        return signale;
    }

    @Before
    public void initTest() {
        signale = createEntity(em);
    }

    @Test
    @Transactional
    public void createSignale() throws Exception {
        int databaseSizeBeforeCreate = signaleRepository.findAll().size();

        // Create the Signale
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);
        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isCreated());

        // Validate the Signale in the database
        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeCreate + 1);
        Signale testSignale = signaleList.get(signaleList.size() - 1);
        assertThat(testSignale.getSignaleType()).isEqualTo(DEFAULT_SIGNALE_TYPE);
        assertThat(testSignale.getSignaleName()).isEqualTo(DEFAULT_SIGNALE_NAME);
        assertThat(testSignale.getLongSignale()).isEqualTo(DEFAULT_LONG_SIGNALE);
        assertThat(testSignale.getLatSignale()).isEqualTo(DEFAULT_LAT_SIGNALE);
    }

    @Test
    @Transactional
    public void createSignaleWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = signaleRepository.findAll().size();

        // Create the Signale with an existing ID
        signale.setId(1L);
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Signale in the database
        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSignaleTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = signaleRepository.findAll().size();
        // set the field null
        signale.setSignaleType(null);

        // Create the Signale, which fails.
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSignaleNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = signaleRepository.findAll().size();
        // set the field null
        signale.setSignaleName(null);

        // Create the Signale, which fails.
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLongSignaleIsRequired() throws Exception {
        int databaseSizeBeforeTest = signaleRepository.findAll().size();
        // set the field null
        signale.setLongSignale(null);

        // Create the Signale, which fails.
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLatSignaleIsRequired() throws Exception {
        int databaseSizeBeforeTest = signaleRepository.findAll().size();
        // set the field null
        signale.setLatSignale(null);

        // Create the Signale, which fails.
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        restSignaleMockMvc.perform(post("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSignales() throws Exception {
        // Initialize the database
        signaleRepository.saveAndFlush(signale);

        // Get all the signaleList
        restSignaleMockMvc.perform(get("/api/signales?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(signale.getId().intValue())))
            .andExpect(jsonPath("$.[*].signaleType").value(hasItem(DEFAULT_SIGNALE_TYPE.toString())))
            .andExpect(jsonPath("$.[*].signaleName").value(hasItem(DEFAULT_SIGNALE_NAME.toString())))
            .andExpect(jsonPath("$.[*].longSignale").value(hasItem(DEFAULT_LONG_SIGNALE.doubleValue())))
            .andExpect(jsonPath("$.[*].latSignale").value(hasItem(DEFAULT_LAT_SIGNALE.doubleValue())));
    }
    

    @Test
    @Transactional
    public void getSignale() throws Exception {
        // Initialize the database
        signaleRepository.saveAndFlush(signale);

        // Get the signale
        restSignaleMockMvc.perform(get("/api/signales/{id}", signale.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(signale.getId().intValue()))
            .andExpect(jsonPath("$.signaleType").value(DEFAULT_SIGNALE_TYPE.toString()))
            .andExpect(jsonPath("$.signaleName").value(DEFAULT_SIGNALE_NAME.toString()))
            .andExpect(jsonPath("$.longSignale").value(DEFAULT_LONG_SIGNALE.doubleValue()))
            .andExpect(jsonPath("$.latSignale").value(DEFAULT_LAT_SIGNALE.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSignale() throws Exception {
        // Get the signale
        restSignaleMockMvc.perform(get("/api/signales/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSignale() throws Exception {
        // Initialize the database
        signaleRepository.saveAndFlush(signale);

        int databaseSizeBeforeUpdate = signaleRepository.findAll().size();

        // Update the signale
        Signale updatedSignale = signaleRepository.findById(signale.getId()).get();
        // Disconnect from session so that the updates on updatedSignale are not directly saved in db
        em.detach(updatedSignale);
        updatedSignale
            .signaleType(UPDATED_SIGNALE_TYPE)
            .signaleName(UPDATED_SIGNALE_NAME)
            .longSignale(UPDATED_LONG_SIGNALE)
            .latSignale(UPDATED_LAT_SIGNALE);
        SignaleDTO signaleDTO = signaleMapper.toDto(updatedSignale);

        restSignaleMockMvc.perform(put("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isOk());

        // Validate the Signale in the database
        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeUpdate);
        Signale testSignale = signaleList.get(signaleList.size() - 1);
        assertThat(testSignale.getSignaleType()).isEqualTo(UPDATED_SIGNALE_TYPE);
        assertThat(testSignale.getSignaleName()).isEqualTo(UPDATED_SIGNALE_NAME);
        assertThat(testSignale.getLongSignale()).isEqualTo(UPDATED_LONG_SIGNALE);
        assertThat(testSignale.getLatSignale()).isEqualTo(UPDATED_LAT_SIGNALE);
    }

    @Test
    @Transactional
    public void updateNonExistingSignale() throws Exception {
        int databaseSizeBeforeUpdate = signaleRepository.findAll().size();

        // Create the Signale
        SignaleDTO signaleDTO = signaleMapper.toDto(signale);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restSignaleMockMvc.perform(put("/api/signales")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signaleDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Signale in the database
        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSignale() throws Exception {
        // Initialize the database
        signaleRepository.saveAndFlush(signale);

        int databaseSizeBeforeDelete = signaleRepository.findAll().size();

        // Get the signale
        restSignaleMockMvc.perform(delete("/api/signales/{id}", signale.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Signale> signaleList = signaleRepository.findAll();
        assertThat(signaleList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Signale.class);
        Signale signale1 = new Signale();
        signale1.setId(1L);
        Signale signale2 = new Signale();
        signale2.setId(signale1.getId());
        assertThat(signale1).isEqualTo(signale2);
        signale2.setId(2L);
        assertThat(signale1).isNotEqualTo(signale2);
        signale1.setId(null);
        assertThat(signale1).isNotEqualTo(signale2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SignaleDTO.class);
        SignaleDTO signaleDTO1 = new SignaleDTO();
        signaleDTO1.setId(1L);
        SignaleDTO signaleDTO2 = new SignaleDTO();
        assertThat(signaleDTO1).isNotEqualTo(signaleDTO2);
        signaleDTO2.setId(signaleDTO1.getId());
        assertThat(signaleDTO1).isEqualTo(signaleDTO2);
        signaleDTO2.setId(2L);
        assertThat(signaleDTO1).isNotEqualTo(signaleDTO2);
        signaleDTO1.setId(null);
        assertThat(signaleDTO1).isNotEqualTo(signaleDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(signaleMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(signaleMapper.fromId(null)).isNull();
    }
}
