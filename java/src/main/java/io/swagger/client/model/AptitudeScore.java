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
 * Object representing a Assessment scores
 */
@Schema(description = "Object representing a Assessment scores")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-01-16T14:47:13.401Z[GMT]")
public class AptitudeScore {
  @SerializedName("verbalReasoning")
  private Double verbalReasoning = null;

  @SerializedName("perceptualSpeed")
  private Double perceptualSpeed = null;

  @SerializedName("numberSpeed")
  private Double numberSpeed = null;

  @SerializedName("wordMeaning")
  private Double wordMeaning = null;

  @SerializedName("spatialVisualisation")
  private Double spatialVisualisation = null;

  public AptitudeScore verbalReasoning(Double verbalReasoning) {
    this.verbalReasoning = verbalReasoning;
    return this;
  }

   /**
   * Verbal reasoning
   * @return verbalReasoning
  **/
  @Schema(description = "Verbal reasoning")
  public Double getVerbalReasoning() {
    return verbalReasoning;
  }

  public void setVerbalReasoning(Double verbalReasoning) {
    this.verbalReasoning = verbalReasoning;
  }

  public AptitudeScore perceptualSpeed(Double perceptualSpeed) {
    this.perceptualSpeed = perceptualSpeed;
    return this;
  }

   /**
   * Perceptual speed
   * @return perceptualSpeed
  **/
  @Schema(description = "Perceptual speed")
  public Double getPerceptualSpeed() {
    return perceptualSpeed;
  }

  public void setPerceptualSpeed(Double perceptualSpeed) {
    this.perceptualSpeed = perceptualSpeed;
  }

  public AptitudeScore numberSpeed(Double numberSpeed) {
    this.numberSpeed = numberSpeed;
    return this;
  }

   /**
   * Number speed
   * @return numberSpeed
  **/
  @Schema(description = "Number speed")
  public Double getNumberSpeed() {
    return numberSpeed;
  }

  public void setNumberSpeed(Double numberSpeed) {
    this.numberSpeed = numberSpeed;
  }

  public AptitudeScore wordMeaning(Double wordMeaning) {
    this.wordMeaning = wordMeaning;
    return this;
  }

   /**
   * Word meaning
   * @return wordMeaning
  **/
  @Schema(description = "Word meaning")
  public Double getWordMeaning() {
    return wordMeaning;
  }

  public void setWordMeaning(Double wordMeaning) {
    this.wordMeaning = wordMeaning;
  }

  public AptitudeScore spatialVisualisation(Double spatialVisualisation) {
    this.spatialVisualisation = spatialVisualisation;
    return this;
  }

   /**
   * Spatial visualisation
   * @return spatialVisualisation
  **/
  @Schema(description = "Spatial visualisation")
  public Double getSpatialVisualisation() {
    return spatialVisualisation;
  }

  public void setSpatialVisualisation(Double spatialVisualisation) {
    this.spatialVisualisation = spatialVisualisation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AptitudeScore aptitudeScore = (AptitudeScore) o;
    return Objects.equals(this.verbalReasoning, aptitudeScore.verbalReasoning) &&
        Objects.equals(this.perceptualSpeed, aptitudeScore.perceptualSpeed) &&
        Objects.equals(this.numberSpeed, aptitudeScore.numberSpeed) &&
        Objects.equals(this.wordMeaning, aptitudeScore.wordMeaning) &&
        Objects.equals(this.spatialVisualisation, aptitudeScore.spatialVisualisation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verbalReasoning, perceptualSpeed, numberSpeed, wordMeaning, spatialVisualisation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AptitudeScore {\n");
    
    sb.append("    verbalReasoning: ").append(toIndentedString(verbalReasoning)).append("\n");
    sb.append("    perceptualSpeed: ").append(toIndentedString(perceptualSpeed)).append("\n");
    sb.append("    numberSpeed: ").append(toIndentedString(numberSpeed)).append("\n");
    sb.append("    wordMeaning: ").append(toIndentedString(wordMeaning)).append("\n");
    sb.append("    spatialVisualisation: ").append(toIndentedString(spatialVisualisation)).append("\n");
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
