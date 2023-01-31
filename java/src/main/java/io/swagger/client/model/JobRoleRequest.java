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
import io.swagger.client.model.JobRoleCharacteristic;
import io.swagger.client.model.JobRoleLearning;
import io.swagger.client.model.JobRoleLevel;
import io.swagger.client.model.JobRolePace;
import io.swagger.client.model.JobRoleVariety;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Object representing a Job Role request
 */
@Schema(description = "Object representing a Job Role request")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-01-16T14:47:13.401Z[GMT]")
public class JobRoleRequest {
  @SerializedName("title")
  private String title = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("level")
  private JobRoleLevel level = null;

  @SerializedName("learning")
  private JobRoleLearning learning = null;

  @SerializedName("pace")
  private JobRolePace pace = null;

  @SerializedName("variety")
  private JobRoleVariety variety = null;

  @SerializedName("characteristics")
  private List<JobRoleCharacteristic> characteristics = new ArrayList<JobRoleCharacteristic>();

  public JobRoleRequest title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Title of the Job Role
   * @return title
  **/
  @Schema(required = true, description = "Title of the Job Role")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public JobRoleRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Longer description of the role, including any necessary criteria
   * @return description
  **/
  @Schema(description = "Longer description of the role, including any necessary criteria")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public JobRoleRequest level(JobRoleLevel level) {
    this.level = level;
    return this;
  }

   /**
   * Get level
   * @return level
  **/
  @Schema(required = true, description = "")
  public JobRoleLevel getLevel() {
    return level;
  }

  public void setLevel(JobRoleLevel level) {
    this.level = level;
  }

  public JobRoleRequest learning(JobRoleLearning learning) {
    this.learning = learning;
    return this;
  }

   /**
   * Get learning
   * @return learning
  **/
  @Schema(required = true, description = "")
  public JobRoleLearning getLearning() {
    return learning;
  }

  public void setLearning(JobRoleLearning learning) {
    this.learning = learning;
  }

  public JobRoleRequest pace(JobRolePace pace) {
    this.pace = pace;
    return this;
  }

   /**
   * Get pace
   * @return pace
  **/
  @Schema(required = true, description = "")
  public JobRolePace getPace() {
    return pace;
  }

  public void setPace(JobRolePace pace) {
    this.pace = pace;
  }

  public JobRoleRequest variety(JobRoleVariety variety) {
    this.variety = variety;
    return this;
  }

   /**
   * Get variety
   * @return variety
  **/
  @Schema(required = true, description = "")
  public JobRoleVariety getVariety() {
    return variety;
  }

  public void setVariety(JobRoleVariety variety) {
    this.variety = variety;
  }

  public JobRoleRequest characteristics(List<JobRoleCharacteristic> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public JobRoleRequest addCharacteristicsItem(JobRoleCharacteristic characteristicsItem) {
    this.characteristics.add(characteristicsItem);
    return this;
  }

   /**
   * Core characteristics. Exactly three different values must be selected:  Analytical, Communicative, Decisive, Driven, Emotionally, Resilient, Independent, Innovative, ProcessOriented, Supportive
   * @return characteristics
  **/
  @Schema(required = true, description = "Core characteristics. Exactly three different values must be selected:  Analytical, Communicative, Decisive, Driven, Emotionally, Resilient, Independent, Innovative, ProcessOriented, Supportive")
  public List<JobRoleCharacteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<JobRoleCharacteristic> characteristics) {
    this.characteristics = characteristics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobRoleRequest jobRoleRequest = (JobRoleRequest) o;
    return Objects.equals(this.title, jobRoleRequest.title) &&
        Objects.equals(this.description, jobRoleRequest.description) &&
        Objects.equals(this.level, jobRoleRequest.level) &&
        Objects.equals(this.learning, jobRoleRequest.learning) &&
        Objects.equals(this.pace, jobRoleRequest.pace) &&
        Objects.equals(this.variety, jobRoleRequest.variety) &&
        Objects.equals(this.characteristics, jobRoleRequest.characteristics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, level, learning, pace, variety, characteristics);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobRoleRequest {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    learning: ").append(toIndentedString(learning)).append("\n");
    sb.append("    pace: ").append(toIndentedString(pace)).append("\n");
    sb.append("    variety: ").append(toIndentedString(variety)).append("\n");
    sb.append("    characteristics: ").append(toIndentedString(characteristics)).append("\n");
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
