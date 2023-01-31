using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Assessment Order result
/// </summary>
[ExcludeFromCodeCoverage]
public class AssessmentOrderResult
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
    /// Assessment orders results
    /// </summary>
    [JsonPropertyName("results")]
    public Results Results { get; set; } = default!;
}