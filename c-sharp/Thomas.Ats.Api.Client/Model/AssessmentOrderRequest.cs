using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing an Assessment Order object to create
/// </summary>
public class AssessmentOrderRequest
{
    /// <summary>
    /// An ID to represent this instance of a candidate being tested against a role
    /// </summary>
    [JsonPropertyName("id")]
    public string Id { get; set; } = string.Empty;

    /// <summary>
    /// The candidate's email address. They will receive an email inviting them to take the tests
    /// </summary>
    [JsonPropertyName("email")]
    [Required]
    [EmailAddress]
    public string? Email { get; set; }

    /// <summary>
    /// The assessments to request the candidate completes
    /// Example: List [ "Aptitude", "Behaviour", "Personality" ]
    /// </summary>
    [JsonPropertyName("assessments")]
    [Required]
    [MinLength(1)]
    [MaxLength(3)]
    public AssessmentType[]? Assessments { get; set; } = default;


    /// <summary>
    /// The callback url to send assessments results
    /// </summary>
    [JsonPropertyName("callbackUrl")]
    [Required]
    public string? CallbackUrl { get; set; }
}