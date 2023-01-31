using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Assessment scores
/// </summary>
public class AptitudeScore
{
    /// <summary>
    /// Verbal reasoning
    /// </summary>
    [JsonPropertyName("verbalReasoning")]
    public double VerbalReasoning { get; set; }

    /// <summary>
    /// Perceptual speed
    /// </summary>
    [JsonPropertyName("perceptualSpeed")]
    public double PerceptualSpeed { get; set; }

    /// <summary>
    /// Number speed
    /// </summary>
    [JsonPropertyName("numberSpeed")]
    public double NumberSpeed { get; set; }

    /// <summary>
    /// Word meaning
    /// </summary>
    [JsonPropertyName("wordMeaning")]
    public double WordMeaning { get; set; }

    /// <summary>
    /// Spatial visualisation
    /// </summary>
    [JsonPropertyName("spatialVisualisation")]
    public double SpatialVisualisation { get; set; }
}