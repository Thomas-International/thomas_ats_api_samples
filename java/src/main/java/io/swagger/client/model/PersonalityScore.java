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
 * Object representing a Personality scores.
 */
@Schema(description = "Object representing a Personality scores.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-01-16T14:47:13.401Z[GMT]")
public class PersonalityScore {
  @SerializedName("conscientiousness")
  private Double conscientiousness = null;

  @SerializedName("adjustment")
  private Double adjustment = null;

  @SerializedName("curiosity")
  private Double curiosity = null;

  @SerializedName("riskApproach")
  private Double riskApproach = null;

  @SerializedName("ambiguity")
  private Double ambiguity = null;

  @SerializedName("competitiveness")
  private Double competitiveness = null;

  public PersonalityScore conscientiousness(Double conscientiousness) {
    this.conscientiousness = conscientiousness;
    return this;
  }

   /**
   * Conscientiousness reasoning
   * @return conscientiousness
  **/
  @Schema(description = "Conscientiousness reasoning")
  public Double getConscientiousness() {
    return conscientiousness;
  }

  public void setConscientiousness(Double conscientiousness) {
    this.conscientiousness = conscientiousness;
  }

  public PersonalityScore adjustment(Double adjustment) {
    this.adjustment = adjustment;
    return this;
  }

   /**
   * Adjustment reasoning
   * @return adjustment
  **/
  @Schema(description = "Adjustment reasoning")
  public Double getAdjustment() {
    return adjustment;
  }

  public void setAdjustment(Double adjustment) {
    this.adjustment = adjustment;
  }

  public PersonalityScore curiosity(Double curiosity) {
    this.curiosity = curiosity;
    return this;
  }

   /**
   * Curiosity reasoning
   * @return curiosity
  **/
  @Schema(description = "Curiosity reasoning")
  public Double getCuriosity() {
    return curiosity;
  }

  public void setCuriosity(Double curiosity) {
    this.curiosity = curiosity;
  }

  public PersonalityScore riskApproach(Double riskApproach) {
    this.riskApproach = riskApproach;
    return this;
  }

   /**
   * Risk Approach reasoning
   * @return riskApproach
  **/
  @Schema(description = "Risk Approach reasoning")
  public Double getRiskApproach() {
    return riskApproach;
  }

  public void setRiskApproach(Double riskApproach) {
    this.riskApproach = riskApproach;
  }

  public PersonalityScore ambiguity(Double ambiguity) {
    this.ambiguity = ambiguity;
    return this;
  }

   /**
   * Ambiguity reasoning
   * @return ambiguity
  **/
  @Schema(description = "Ambiguity reasoning")
  public Double getAmbiguity() {
    return ambiguity;
  }

  public void setAmbiguity(Double ambiguity) {
    this.ambiguity = ambiguity;
  }

  public PersonalityScore competitiveness(Double competitiveness) {
    this.competitiveness = competitiveness;
    return this;
  }

   /**
   * Competitiveness reasoning
   * @return competitiveness
  **/
  @Schema(description = "Competitiveness reasoning")
  public Double getCompetitiveness() {
    return competitiveness;
  }

  public void setCompetitiveness(Double competitiveness) {
    this.competitiveness = competitiveness;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonalityScore personalityScore = (PersonalityScore) o;
    return Objects.equals(this.conscientiousness, personalityScore.conscientiousness) &&
        Objects.equals(this.adjustment, personalityScore.adjustment) &&
        Objects.equals(this.curiosity, personalityScore.curiosity) &&
        Objects.equals(this.riskApproach, personalityScore.riskApproach) &&
        Objects.equals(this.ambiguity, personalityScore.ambiguity) &&
        Objects.equals(this.competitiveness, personalityScore.competitiveness);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conscientiousness, adjustment, curiosity, riskApproach, ambiguity, competitiveness);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonalityScore {\n");
    
    sb.append("    conscientiousness: ").append(toIndentedString(conscientiousness)).append("\n");
    sb.append("    adjustment: ").append(toIndentedString(adjustment)).append("\n");
    sb.append("    curiosity: ").append(toIndentedString(curiosity)).append("\n");
    sb.append("    riskApproach: ").append(toIndentedString(riskApproach)).append("\n");
    sb.append("    ambiguity: ").append(toIndentedString(ambiguity)).append("\n");
    sb.append("    competitiveness: ").append(toIndentedString(competitiveness)).append("\n");
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
