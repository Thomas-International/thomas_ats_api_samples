using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Job Role Results
/// </summary>
[ExcludeFromCodeCoverage]
public class JobRoleResults
{
    /// <summary>
    /// Star Ratings
    /// </summary>
    [JsonPropertyName("starRatings")]
    public StarRatings? StarRatings { get; set; }

    /// <summary>
    /// Assessment Scores
    /// </summary>
    [JsonPropertyName("assessmentScores")]
    public AssessmentScores? AssessmentScores { get; set; }
}