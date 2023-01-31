/*
 * Thomas Perform ATS Partner API
 * # API Description  This API exists for the purpose of connecting an Applicant Tracking System (ATS) to the Thomas Perform talent assessment platform for the purpose of submitting candidates for assessments and retrieving their scores and reports.  During development you will be provided with an organisation account on our sandbox developer platform and an API key for accessing. Once your integration is complete, our customers will be able to request connection to your application by contacting our Customer Success team.  # Authentication  The API key that has been provided needs to be passed as a Bearer token in the Authorization header of every call on this API. This key represents credentials for one organisation and one application. Any calls that omit this key or provide an incorrect key will recieve a HTTP status 401 error.  API keys will not expire automatically, but customer organisations can request to regenerate or disable them at any time.  # Job Role Assesment Order vs Assesment Order  There are two ways to submit candidates for Thomas Assessments.  * You can submit a candidate to a specific Job Role. This requires the candidate to take all three of our Assessments, and will provide job specific star ratings of the candidate's suitability to the role as well as the detailed assessment outcomes. You will also get access to our more detailed candidate profile page, with downloadable reports and interview guide. This is our recommended workflow for most Thomas Perform customers. * You can submit a candidate to just take a specific selection of assessments. This will provide the outcomes for the selected assessments, but no star ratings or candidate profile. This is only recommended for customers that have been through Thomas training for interpreting assessment outcomes.  # JobRoleAssessmentOrder workflow  ![Sequence Diagram](images/jobRoleSeq.png) * When setting up a vacancy workflow in your ATS, use the GET Role endpoint to present the user with a list of roles in Thomas Perform that they can submit candidates to.  * Optionally prompt the user to create a new role, and submit their specification using the POST Role endpoint. If using this approach, the meanings for the settings are described in [our knowledgebase](https://knowledge.thomas.co/en/articles/4363659-select-success-characteristics), and within Thomas Perform itself. Please use the same wording to describe the characteristics where possible. * Submit a candidate for tests, specifying at least their email address and the ID of the selected job role. The candidate will receive an email at this address inviting them to complete the assessments.   * Optionally include a Callback Url for notification of test completion. This is preferred to polling the results URL   * Optionally provide a unique Id for the AssessmentOrder. If you do not provide one, it will be generated for you.  * The email contains a link. Candidates will be able to create a new Thomas Profile account or log in to an existing one.    * If they have already completed assessments, they will not need to retake them and their results will be shared with you.    * If they create a new account, they will be offered three assessments to take. They may do them in any order, and you will recieve the results when all three have been completed. * If you specified a Callback Url, you will be notified that the tests are complete * Retrieve the test results and star ratings from the GET JobRoleAssessmentOrder endpoint, specifying the Id  # AssessmentOrder workflow ![Sequence Diagram](images/nonJobRoleSeq.png) * Submit a candidate for tests at the POST AssessmentOrder endpoint, specifying at least their email address and the tests you wish them to complete. The candidate will receive an email at this address inviting them to complete the assessments.   * Optionally include a Callback Url for notification of test completion. This is preferred to polling the results URL   * Optionally provide a unique Id for the AssessmentOrder. If you do not provide one, it will be generated for you.  * The email contains a link. Candidates will be able to create a new Thomas Profile account or log in to an existing one.    * If they have already completed assessments, they will not need to retake them and their results will be shared with you.    * If they create a new account, they will be offered the assessments you requested them to take. They may do them in any order, and you will recieve the results when all three have been completed. They may also take any tests you did not request, but these results will not be shared with you. * If you specified a Callback Url, you will be notified that the tests are complete * Retrieve the test results from the GET AssessmentOrder endpoint, specifying the Id  # Callback  When submitting a candidate for assessments, you can optionally specify a callback URL. When the candidate has completed their final requested assessment we will send a POST message to that URL with a body similar to the following.      {         \"id\": \"52F9DC5C-287B-430B-92E6-B393772EA359\",         \"resultEndpoint\": \"https://dev-api.thomas.co/ats-open-api/v1/jobRoleAssessmentOrder/52F9DC5C-287B-430B-92E6-B393772EA359\"            }  Any success HTTP response code (codes in the 2xx range) will acknowledge receipt of the notification. Any other response code or connection error will trigger a retry later. This notification is unauthenticated, so the candidate results must be retrieved from our own API at the endpoint specified, using our standard authorization token.  # Results page  ![Screenshot of results page](images/resultsPage.png) The results object for a JobRoleAssessmentOrder includes a URL to a results page and a PIN code that a user must enter to authenticate that page. The URL and PIN are specific to the individual JobRoleAssessmentOrder and do not provide access to other candidate data. The complete list of candidates for a role can be viewed only by users who have an account on Thomas Perform.  The results page provides more information about the candidate and their suitability to the role, as well as an interview guide providing recommended questions to ask during a job interview. All of this information can optionally be downloaded as a PDF report.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Object representing Star Ratings for the candidate&#x27;s suitability for this role
 */
@Schema(description = "Object representing Star Ratings for the candidate's suitability for this role")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-01-16T14:47:13.401Z[GMT]")
public class StarRatings {
  @SerializedName("overallStarRating")
  private Double overallStarRating = null;

  @SerializedName("aptitudeStarRating")
  private Double aptitudeStarRating = null;

  @SerializedName("behaviourStarRating")
  private Double behaviourStarRating = null;

  @SerializedName("personalityStarRating")
  private Double personalityStarRating = null;

  public StarRatings overallStarRating(Double overallStarRating) {
    this.overallStarRating = overallStarRating;
    return this;
  }

   /**
   * Overall candidate star rating
   * minimum: 0
   * maximum: 5
   * @return overallStarRating
  **/
  @Schema(description = "Overall candidate star rating")
  public Double getOverallStarRating() {
    return overallStarRating;
  }

  public void setOverallStarRating(Double overallStarRating) {
    this.overallStarRating = overallStarRating;
  }

  public StarRatings aptitudeStarRating(Double aptitudeStarRating) {
    this.aptitudeStarRating = aptitudeStarRating;
    return this;
  }

   /**
   * The behaviour rating provides information around how a person prefers to behave at work and the characteristics they will demonstrate,  communication style, what motivates them and an insight into their strengths, areas for development and value to the organisation
   * minimum: 0
   * maximum: 5
   * @return aptitudeStarRating
  **/
  @Schema(description = "The behaviour rating provides information around how a person prefers to behave at work and the characteristics they will demonstrate,  communication style, what motivates them and an insight into their strengths, areas for development and value to the organisation")
  public Double getAptitudeStarRating() {
    return aptitudeStarRating;
  }

  public void setAptitudeStarRating(Double aptitudeStarRating) {
    this.aptitudeStarRating = aptitudeStarRating;
  }

  public StarRatings behaviourStarRating(Double behaviourStarRating) {
    this.behaviourStarRating = behaviourStarRating;
    return this;
  }

   /**
   * The aptitude rating indicates a person&#x27;s fluid intelligence i.e. how quickly they will learn and retain new skills and procedures and how quickly  they can grasp a new role. It looks at an individual&#x27;s speed of processing information and ability to learn and develop new skills and is used for  a variety of purposes: recruitment, retention, development, management, identifying training needs, career guidance, succession planning and benchmarking
   * minimum: 0
   * maximum: 5
   * @return behaviourStarRating
  **/
  @Schema(description = "The aptitude rating indicates a person's fluid intelligence i.e. how quickly they will learn and retain new skills and procedures and how quickly  they can grasp a new role. It looks at an individual's speed of processing information and ability to learn and develop new skills and is used for  a variety of purposes: recruitment, retention, development, management, identifying training needs, career guidance, succession planning and benchmarking")
  public Double getBehaviourStarRating() {
    return behaviourStarRating;
  }

  public void setBehaviourStarRating(Double behaviourStarRating) {
    this.behaviourStarRating = behaviourStarRating;
  }

  public StarRatings personalityStarRating(Double personalityStarRating) {
    this.personalityStarRating = personalityStarRating;
    return this;
  }

   /**
   * The personality rating gives you insight into the underlying traits that drive how a person works and interacts with those around them.  A personality trait is an enduring characteristic of a person and describes a person’s desire for success, their reaction to stress,  their preference for novelty, their approach to risk, their tolerance of uncertainty and their desire for power and influence
   * minimum: 0
   * maximum: 5
   * @return personalityStarRating
  **/
  @Schema(description = "The personality rating gives you insight into the underlying traits that drive how a person works and interacts with those around them.  A personality trait is an enduring characteristic of a person and describes a person’s desire for success, their reaction to stress,  their preference for novelty, their approach to risk, their tolerance of uncertainty and their desire for power and influence")
  public Double getPersonalityStarRating() {
    return personalityStarRating;
  }

  public void setPersonalityStarRating(Double personalityStarRating) {
    this.personalityStarRating = personalityStarRating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StarRatings starRatings = (StarRatings) o;
    return Objects.equals(this.overallStarRating, starRatings.overallStarRating) &&
        Objects.equals(this.aptitudeStarRating, starRatings.aptitudeStarRating) &&
        Objects.equals(this.behaviourStarRating, starRatings.behaviourStarRating) &&
        Objects.equals(this.personalityStarRating, starRatings.personalityStarRating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(overallStarRating, aptitudeStarRating, behaviourStarRating, personalityStarRating);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StarRatings {\n");
    
    sb.append("    overallStarRating: ").append(toIndentedString(overallStarRating)).append("\n");
    sb.append("    aptitudeStarRating: ").append(toIndentedString(aptitudeStarRating)).append("\n");
    sb.append("    behaviourStarRating: ").append(toIndentedString(behaviourStarRating)).append("\n");
    sb.append("    personalityStarRating: ").append(toIndentedString(personalityStarRating)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
