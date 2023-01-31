using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Job Role Assessment Order object to create
/// </summary>
public class JobRoleAssessmentOrderRequest
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
    public string Email { get; set; } = string.Empty;

    /// <summary>
    /// The ID of the Job Role
    /// </summary>
    [JsonPropertyName("roleId")]
    [Required]
    public Guid RoleId { get; set; }

    /// <summary>
    /// The callback url to send Assessments results
    /// Example: https://yourapi.example.com/notifyResults/
    /// </summary>
    [JsonPropertyName("callbackUrl")]
    public string? CallbackUrl { get; set; }
}