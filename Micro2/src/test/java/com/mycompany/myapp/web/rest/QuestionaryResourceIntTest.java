package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.Micro2App;

import com.mycompany.myapp.domain.Questionary;
import com.mycompany.myapp.repository.QuestionaryRepository;
import com.mycompany.myapp.service.QuestionaryService;
import com.mycompany.myapp.service.dto.QuestionaryDTO;
import com.mycompany.myapp.service.mapper.QuestionaryMapper;
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

import com.mycompany.myapp.domain.enumeration.DomandaUno;
import com.mycompany.myapp.domain.enumeration.DomandaDue;
import com.mycompany.myapp.domain.enumeration.DomandaSette;
import com.mycompany.myapp.domain.enumeration.DomandaTre;
import com.mycompany.myapp.domain.enumeration.DomandaQuattro;
import com.mycompany.myapp.domain.enumeration.DomandaCinque;
import com.mycompany.myapp.domain.enumeration.DomandaSei;
/**
 * Test class for the QuestionaryResource REST controller.
 *
 * @see QuestionaryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class QuestionaryResourceIntTest {

    private static final DomandaUno DEFAULT_DOMANDA_UNO = DomandaUno.DOMANDAUNOOPZIONEUNO;
    private static final DomandaUno UPDATED_DOMANDA_UNO = DomandaUno.DOMANDAUNOOPZIONEDUE;

    private static final DomandaDue DEFAULT_DOMANDA_DUE = DomandaDue.DOMANDADUEOPZIONEUNO;
    private static final DomandaDue UPDATED_DOMANDA_DUE = DomandaDue.DOMANDADUEOPZIONEDUE;

    private static final DomandaSette DEFAULT_DOMANDA_SETTE = DomandaSette.DOMANDASETTEOPZIONEUNO;
    private static final DomandaSette UPDATED_DOMANDA_SETTE = DomandaSette.DOMANDASETTEOPZIONEDUE;

    private static final DomandaTre DEFAULT_DOMANDA_TRE = DomandaTre.DOMANDATREOPZIONEUNO;
    private static final DomandaTre UPDATED_DOMANDA_TRE = DomandaTre.DOMANDATREOPZIONEDUE;

    private static final DomandaQuattro DEFAULT_DOMANDA_QUATTRO = DomandaQuattro.DOMANDAQUATTROOPZIONEUNO;
    private static final DomandaQuattro UPDATED_DOMANDA_QUATTRO = DomandaQuattro.DOMANDAQUATTROOPZIONEDUE;

    private static final DomandaCinque DEFAULT_DOMANDA_CINQUE = DomandaCinque.DOMANDACINQUEOPZIONEUNO;
    private static final DomandaCinque UPDATED_DOMANDA_CINQUE = DomandaCinque.DOMANDACINQUEOPZIONEDUE;

    private static final DomandaSei DEFAULT_DOMANDA_SEI = DomandaSei.DOMANDASEIOPZIONEUNO;
    private static final DomandaSei UPDATED_DOMANDA_SEI = DomandaSei.DOMANDASEIOPZIONEDUE;

    @Autowired
    private QuestionaryRepository questionaryRepository;


    @Autowired
    private QuestionaryMapper questionaryMapper;
    

    @Autowired
    private QuestionaryService questionaryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restQuestionaryMockMvc;

    private Questionary questionary;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final QuestionaryResource questionaryResource = new QuestionaryResource(questionaryService);
        this.restQuestionaryMockMvc = MockMvcBuilders.standaloneSetup(questionaryResource)
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
    public static Questionary createEntity(EntityManager em) {
        Questionary questionary = new Questionary()
            .domandaUno(DEFAULT_DOMANDA_UNO)
            .domandaDue(DEFAULT_DOMANDA_DUE)
            .domandaSette(DEFAULT_DOMANDA_SETTE)
            .domandaTre(DEFAULT_DOMANDA_TRE)
            .domandaQuattro(DEFAULT_DOMANDA_QUATTRO)
            .domandaCinque(DEFAULT_DOMANDA_CINQUE)
            .domandaSei(DEFAULT_DOMANDA_SEI);
        return questionary;
    }

    @Before
    public void initTest() {
        questionary = createEntity(em);
    }

    @Test
    @Transactional
    public void createQuestionary() throws Exception {
        int databaseSizeBeforeCreate = questionaryRepository.findAll().size();

        // Create the Questionary
        QuestionaryDTO questionaryDTO = questionaryMapper.toDto(questionary);
        restQuestionaryMockMvc.perform(post("/api/questionaries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questionaryDTO)))
            .andExpect(status().isCreated());

        // Validate the Questionary in the database
        List<Questionary> questionaryList = questionaryRepository.findAll();
        assertThat(questionaryList).hasSize(databaseSizeBeforeCreate + 1);
        Questionary testQuestionary = questionaryList.get(questionaryList.size() - 1);
        assertThat(testQuestionary.getDomandaUno()).isEqualTo(DEFAULT_DOMANDA_UNO);
        assertThat(testQuestionary.getDomandaDue()).isEqualTo(DEFAULT_DOMANDA_DUE);
        assertThat(testQuestionary.getDomandaSette()).isEqualTo(DEFAULT_DOMANDA_SETTE);
        assertThat(testQuestionary.getDomandaTre()).isEqualTo(DEFAULT_DOMANDA_TRE);
        assertThat(testQuestionary.getDomandaQuattro()).isEqualTo(DEFAULT_DOMANDA_QUATTRO);
        assertThat(testQuestionary.getDomandaCinque()).isEqualTo(DEFAULT_DOMANDA_CINQUE);
        assertThat(testQuestionary.getDomandaSei()).isEqualTo(DEFAULT_DOMANDA_SEI);
    }

    @Test
    @Transactional
    public void createQuestionaryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = questionaryRepository.findAll().size();

        // Create the Questionary with an existing ID
        questionary.setId(1L);
        QuestionaryDTO questionaryDTO = questionaryMapper.toDto(questionary);

        // An entity with an existing ID cannot be created, so this API call must fail
        restQuestionaryMockMvc.perform(post("/api/questionaries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questionaryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Questionary in the database
        List<Questionary> questionaryList = questionaryRepository.findAll();
        assertThat(questionaryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllQuestionaries() throws Exception {
        // Initialize the database
        questionaryRepository.saveAndFlush(questionary);

        // Get all the questionaryList
        restQuestionaryMockMvc.perform(get("/api/questionaries?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(questionary.getId().intValue())))
            .andExpect(jsonPath("$.[*].domandaUno").value(hasItem(DEFAULT_DOMANDA_UNO.toString())))
            .andExpect(jsonPath("$.[*].domandaDue").value(hasItem(DEFAULT_DOMANDA_DUE.toString())))
            .andExpect(jsonPath("$.[*].domandaSette").value(hasItem(DEFAULT_DOMANDA_SETTE.toString())))
            .andExpect(jsonPath("$.[*].domandaTre").value(hasItem(DEFAULT_DOMANDA_TRE.toString())))
            .andExpect(jsonPath("$.[*].domandaQuattro").value(hasItem(DEFAULT_DOMANDA_QUATTRO.toString())))
            .andExpect(jsonPath("$.[*].domandaCinque").value(hasItem(DEFAULT_DOMANDA_CINQUE.toString())))
            .andExpect(jsonPath("$.[*].domandaSei").value(hasItem(DEFAULT_DOMANDA_SEI.toString())));
    }
    

    @Test
    @Transactional
    public void getQuestionary() throws Exception {
        // Initialize the database
        questionaryRepository.saveAndFlush(questionary);

        // Get the questionary
        restQuestionaryMockMvc.perform(get("/api/questionaries/{id}", questionary.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(questionary.getId().intValue()))
            .andExpect(jsonPath("$.domandaUno").value(DEFAULT_DOMANDA_UNO.toString()))
            .andExpect(jsonPath("$.domandaDue").value(DEFAULT_DOMANDA_DUE.toString()))
            .andExpect(jsonPath("$.domandaSette").value(DEFAULT_DOMANDA_SETTE.toString()))
            .andExpect(jsonPath("$.domandaTre").value(DEFAULT_DOMANDA_TRE.toString()))
            .andExpect(jsonPath("$.domandaQuattro").value(DEFAULT_DOMANDA_QUATTRO.toString()))
            .andExpect(jsonPath("$.domandaCinque").value(DEFAULT_DOMANDA_CINQUE.toString()))
            .andExpect(jsonPath("$.domandaSei").value(DEFAULT_DOMANDA_SEI.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingQuestionary() throws Exception {
        // Get the questionary
        restQuestionaryMockMvc.perform(get("/api/questionaries/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateQuestionary() throws Exception {
        // Initialize the database
        questionaryRepository.saveAndFlush(questionary);

        int databaseSizeBeforeUpdate = questionaryRepository.findAll().size();

        // Update the questionary
        Questionary updatedQuestionary = questionaryRepository.findById(questionary.getId()).get();
        // Disconnect from session so that the updates on updatedQuestionary are not directly saved in db
        em.detach(updatedQuestionary);
        updatedQuestionary
            .domandaUno(UPDATED_DOMANDA_UNO)
            .domandaDue(UPDATED_DOMANDA_DUE)
            .domandaSette(UPDATED_DOMANDA_SETTE)
            .domandaTre(UPDATED_DOMANDA_TRE)
            .domandaQuattro(UPDATED_DOMANDA_QUATTRO)
            .domandaCinque(UPDATED_DOMANDA_CINQUE)
            .domandaSei(UPDATED_DOMANDA_SEI);
        QuestionaryDTO questionaryDTO = questionaryMapper.toDto(updatedQuestionary);

        restQuestionaryMockMvc.perform(put("/api/questionaries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questionaryDTO)))
            .andExpect(status().isOk());

        // Validate the Questionary in the database
        List<Questionary> questionaryList = questionaryRepository.findAll();
        assertThat(questionaryList).hasSize(databaseSizeBeforeUpdate);
        Questionary testQuestionary = questionaryList.get(questionaryList.size() - 1);
        assertThat(testQuestionary.getDomandaUno()).isEqualTo(UPDATED_DOMANDA_UNO);
        assertThat(testQuestionary.getDomandaDue()).isEqualTo(UPDATED_DOMANDA_DUE);
        assertThat(testQuestionary.getDomandaSette()).isEqualTo(UPDATED_DOMANDA_SETTE);
        assertThat(testQuestionary.getDomandaTre()).isEqualTo(UPDATED_DOMANDA_TRE);
        assertThat(testQuestionary.getDomandaQuattro()).isEqualTo(UPDATED_DOMANDA_QUATTRO);
        assertThat(testQuestionary.getDomandaCinque()).isEqualTo(UPDATED_DOMANDA_CINQUE);
        assertThat(testQuestionary.getDomandaSei()).isEqualTo(UPDATED_DOMANDA_SEI);
    }

    @Test
    @Transactional
    public void updateNonExistingQuestionary() throws Exception {
        int databaseSizeBeforeUpdate = questionaryRepository.findAll().size();

        // Create the Questionary
        QuestionaryDTO questionaryDTO = questionaryMapper.toDto(questionary);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restQuestionaryMockMvc.perform(put("/api/questionaries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(questionaryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Questionary in the database
        List<Questionary> questionaryList = questionaryRepository.findAll();
        assertThat(questionaryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteQuestionary() throws Exception {
        // Initialize the database
        questionaryRepository.saveAndFlush(questionary);

        int databaseSizeBeforeDelete = questionaryRepository.findAll().size();

        // Get the questionary
        restQuestionaryMockMvc.perform(delete("/api/questionaries/{id}", questionary.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Questionary> questionaryList = questionaryRepository.findAll();
        assertThat(questionaryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Questionary.class);
        Questionary questionary1 = new Questionary();
        questionary1.setId(1L);
        Questionary questionary2 = new Questionary();
        questionary2.setId(questionary1.getId());
        assertThat(questionary1).isEqualTo(questionary2);
        questionary2.setId(2L);
        assertThat(questionary1).isNotEqualTo(questionary2);
        questionary1.setId(null);
        assertThat(questionary1).isNotEqualTo(questionary2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(QuestionaryDTO.class);
        QuestionaryDTO questionaryDTO1 = new QuestionaryDTO();
        questionaryDTO1.setId(1L);
        QuestionaryDTO questionaryDTO2 = new QuestionaryDTO();
        assertThat(questionaryDTO1).isNotEqualTo(questionaryDTO2);
        questionaryDTO2.setId(questionaryDTO1.getId());
        assertThat(questionaryDTO1).isEqualTo(questionaryDTO2);
        questionaryDTO2.setId(2L);
        assertThat(questionaryDTO1).isNotEqualTo(questionaryDTO2);
        questionaryDTO1.setId(null);
        assertThat(questionaryDTO1).isNotEqualTo(questionaryDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(questionaryMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(questionaryMapper.fromId(null)).isNull();
    }
}
