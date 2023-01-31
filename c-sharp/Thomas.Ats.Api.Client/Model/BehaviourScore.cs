using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Behaviour scores.
/// </summary>
public class BehaviourScore
{
    /// <summary>
    /// Dominance
    /// </summary>
    [JsonPropertyName("dominance")]
    public double Dominance { get; set; }
    
    /// <summary>
    /// Influence
    /// </summary>
    [JsonPropertyName("influence")]
    public double Influence { get; set; }
    
    /// <summary>
    /// Steadiness
    /// </summary>
    [JsonPropertyName("steadiness")]
    public double Steadiness { get; set; }
    
    /// <summary>
    /// Compliance
    /// </summary>
    [JsonPropertyName("compliance")]
    public double Compliance { get; set; }
}