using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Results
/// </summary>
public class Results
{
    /// <summary>
    /// Assessment Scores
    /// </summary>
    [JsonPropertyName("assessmentScores")]
    public AssessmentScores AssessmentScores { get; set; } = new();
}