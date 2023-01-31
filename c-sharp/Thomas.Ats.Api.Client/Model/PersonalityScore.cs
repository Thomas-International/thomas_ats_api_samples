using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Personality scores.
/// </summary>
public class PersonalityScore
{
    /// <summary>
    /// Conscientiousness reasoning
    /// </summary>
    [JsonPropertyName("conscientiousness")]
    public double Conscientiousness { get; set; }
    
    /// <summary>
    /// Adjustment reasoning
    /// </summary>
    [JsonPropertyName("adjustment")]
    public double Adjustment { get; set; }
    
    /// <summary>
    /// Curiosity reasoning
    /// </summary>
    [JsonPropertyName("curiosity")]
    public double Curiosity { get; set; }
    
    /// <summary>
    /// Risk Approach reasoning
    /// </summary>
    [JsonPropertyName("riskApproach")]
    public double RiskApproach { get; set; }
    
    /// <summary>
    /// Ambiguity reasoning
    /// </summary>
    [JsonPropertyName("ambiguity")]
    public double Ambiguity { get; set; }
    
    /// <summary>
    /// Competitiveness reasoning
    /// </summary>
    [JsonPropertyName("competitiveness")]
    public double Competitiveness { get; set; }
}