/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import java.util.Calendar;
import javax.ejb.Stateless;
import survey.dto.*;
import survey.exception.*;
import survey.dao.*;

/**
 *
 * @author vivek
 */
@Stateless(mappedName="ResearcherSurveyFacade")
public class ResearcherSurveyFacadeBean implements ResearcherSurveyFacadeRemote {

    public SurveyDTO getSurvey(String username, int surveyID) 
            throws UserNotFoundException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyDTO survey = null;
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.getSurvey(surveyID);
        
        return survey;
    }
    
    public SurveyDTO createSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, OperationFailedException, 
            InvalidFieldException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO owner = userHelper.checkUserExists(username);
        if (owner == null)
            return null;
        
        SurveyHelper surveyHelper = new SurveyHelper();
        if (!surveyHelper.checkSurveyFields(survey))
            return null;
        
        survey.setOwner(owner);
        survey.setState(ActivityTypes.DRAFT);
        survey.setCreateDate(Calendar.getInstance());
        survey.setUpdateDate(Calendar.getInstance());
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.createSurvey(survey);
        
        if (survey.getSurveyID() <= 0)
            throw new OperationFailedException("The survey could not be saved for the user: " + username);
        
        return survey;
    }
    
    public SurveyDTO updateSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException, 
            InvalidFieldException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO owner = userHelper.checkUserExists(username);
        if (owner == null)
            return null;
        
        // Check survey exists
        SurveyHelper surveyHelper = new SurveyHelper();
        surveyHelper.checkSurveyExists(survey.getSurveyID());
        
        if (!surveyHelper.checkSurveyFields(survey))
            return null;
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != owner.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        survey.setUpdateDate(Calendar.getInstance());
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.updateSurvey(survey);
        
        return survey;
    }
    
    public boolean deleteSurvey(String username, int surveyID)
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO owner = userHelper.checkUserExists(username);
        if (owner == null)
            return false;
        
        // Check survey exists
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != owner.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        return dao.deleteSurvey(surveyID);
    }
    
    public SurveyPageDTO getSurveyPage(String username, int surveyPageID)
            throws UserNotFoundException {
            
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyPageDTO surveyPage = null;
        SurveyPageDAO dao = DAOFactory.getSurveyPageDAO();
        surveyPage = dao.getSurveyPage(surveyPageID);
        
        return surveyPage;
    }
    
    public SurveyPageDTO createSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check if title is empty
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        pageHelper.checkFields(surveyPage);
        
        // Set the survey page state
        surveyPage.setState(ActivityTypes.DRAFT);
        
        // Save to DB
        SurveyPageDAO dao = DAOFactory.getSurveyPageDAO();
        surveyPage = dao.createSurveyPage(surveyID, surveyPage);
        
        if (surveyPage.getSurveyPageID() <= 0)
            throw new OperationFailedException("Survey page could not be created.");
        
        return surveyPage;
    }
    
    public SurveyPageDTO updateSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage)
            throws UserNotFoundException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check if the survey page is valid
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        pageHelper.checkSurveyPageExists(surveyPage.getSurveyPageID());
        
        // Check if title is empty
        pageHelper.checkFields(surveyPage);
        
        // save to DB
        SurveyPageDAO dao = DAOFactory.getSurveyPageDAO();
        surveyPage = dao.updateSurveyPage(surveyID, surveyPage);
        
        return surveyPage;
    }
    
    public boolean deleteSurveyPage(String username, int surveyID, int surveyPageID)
            throws UserNotFoundException, RecordNotFoundException, UserNotAllowedException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return false;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check if the survey page is valid
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        pageHelper.checkSurveyPageExists(surveyPageID);
        
        // Delete the survey page
        SurveyPageDAO dao = DAOFactory.getSurveyPageDAO();
        return dao.deleteSurveyPage(surveyPageID);
    }

    public QuestionDTO createQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check survey page exists
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        SurveyPageDTO surveyPage = pageHelper.checkSurveyPageExists(surveyPageID);
        
        // Check the fields
        QuestionHelper questionHelper = new QuestionHelper();
        if (!questionHelper.checkQuestionFields(question))
            return null;
        
        // Set the state
        question.setState(ActivityTypes.DRAFT);
        
        // Save to DB
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        question = dao.createQuestion(surveyPageID, question);
        
        if (question.getQuestionID() <= 0)
            throw new OperationFailedException("Question could not be created");
        
        return question;
    }
    
    public QuestionDTO updateQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question) 
            throws UserNotFoundException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check survey page exists
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        SurveyPageDTO surveyPage = pageHelper.checkSurveyPageExists(surveyPageID);
        
        // Check question exists
        QuestionHelper questionHelper = new QuestionHelper();
        questionHelper.checkQuestionExists(question.getQuestionID());
        
        // Check the fields
        if (!questionHelper.checkQuestionFields(question))
            return null;
        
        // save to DB
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        question = dao.updateQuestion(question);
        
        return question;
    }
    
    public boolean deleteQuestion(String username, int surveyID, int surveyPageID, int questionID)
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return false;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check question exists
        QuestionHelper questionHelper = new QuestionHelper();
        questionHelper.checkQuestionExists(questionID);
        
        // delete
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        return dao.deleteQuestion(questionID);
    }
    
    public OptionDTO createQuestionOption(String username, int questionID, OptionDTO option) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if the question is valid
        QuestionHelper questionHelper = new QuestionHelper();
        QuestionDTO question = questionHelper.checkQuestionExists(questionID);
        
        // Check the fields of the option
        questionHelper.checkOptionFields(option);
        
        // Save to DB
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        option = dao.createQuestionOption(questionID, option);
        
        if (option.getOptionID() <= 0)
            throw new OperationFailedException("The option could not be created");
        
        return option;
    }
    
    public OptionDTO updateQuestionOption(String username, int questionID, OptionDTO option)
            throws UserNotFoundException, RecordNotFoundException, InvalidFieldException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if the option is valid
        QuestionHelper questionHelper = new QuestionHelper();
        questionHelper.checkOptionExists(option.getOptionID());
        
        // Check the fields of the option
        questionHelper.checkOptionFields(option);
        
        // save to DB
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        option = dao.updateQuestionOption(questionID, option);
        
        return option;
    }
    
    public boolean deleteQuestionOption(String username, int questionID, OptionDTO option)
            throws UserNotFoundException, RecordNotFoundException {
        
        // Check if the user is found
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return false;
        
        // Check if the option is valid
        QuestionHelper questionHelper = new QuestionHelper();
        questionHelper.checkOptionExists(option.getOptionID());
        
        // delete
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        return dao.deleteQuestionOption(questionID, option);
    }

    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria) {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        return dao.findSurveys(username, criteria);
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state) {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        return dao.findSurveys(username, state);
    }
}
