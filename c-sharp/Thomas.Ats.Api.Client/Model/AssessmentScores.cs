using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;
using Thomas.Ats.Api.Client.Model;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Assessment scores
/// </summary>
[ExcludeFromCodeCoverage]
public class AssessmentScores
{
    /// <summary>
    /// Aptitude Score
    /// </summary>
    [JsonPropertyName("aptitude")]
    public AptitudeScore? Aptitude { get; set; }
    
    /// <summary>
    /// Behaviour Score
    /// </summary>
    [JsonPropertyName("behaviour")]
    public BehaviourScore? Behaviour { get; set; }
    
    /// <summary>
    /// Personality Score
    /// </summary>
    [JsonPropertyName("personality")]
    public PersonalityScore? Personality { get; set; }
}