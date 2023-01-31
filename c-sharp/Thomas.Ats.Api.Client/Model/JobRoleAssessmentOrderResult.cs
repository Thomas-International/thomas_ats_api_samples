using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing an Assessment Order result
/// </summary>
public class JobRoleAssessmentOrderResult
{
    /// <summary>
    /// An ID to represent this instance of a candidate being tested against a role
    /// </summary>
    [JsonPropertyName("id")]
    public string Id { get; set; } = string.Empty;

    /// <summary>
    /// This will be true if the candidate has completed all of the required assessments and a score is available
    /// </summary>
    [JsonPropertyName("complete")]
    public bool Complete { get; set; } = false;
    
    /// <summary>
    /// Assessment Orders results
    /// </summary>
    [JsonPropertyName("results")]
    public JobRoleResults? Results { get; set; }
}