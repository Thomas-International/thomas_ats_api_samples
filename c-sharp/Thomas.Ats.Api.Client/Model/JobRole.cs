using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Job Role
/// </summary>
[ExcludeFromCodeCoverage]
public class JobRole
{
    /// <summary>
    /// Job Role ID
    /// </summary>
    [JsonPropertyName("id")]
    public Guid RoleId { get; init; }

    /// <summary>
    /// Title of the Job Role
    /// </summary>
    [JsonPropertyName("title")]
    public string Title { get; init; } = string.Empty;

    /// <summary>
    /// Longer description of the Job Role, including any necessary criteria
    /// </summary>
    [JsonPropertyName("description")]
    public string Description { get; init; } = string.Empty;

    /// <summary>
    /// Amount of experience required: EntryLevel, Graduate, Experienced, Management
    /// </summary>
    [JsonPropertyName("level")]
    public JobRoleLevel Level { get; init; }

    /// <summary>
    /// Learning required: None, Initial, Ongoing, Constant
    /// </summary>
    [JsonPropertyName("learning")]
    public JobRoleLearning Learning { get; init; } = JobRoleLearning.None;

    /// <summary>
    /// Time available to pick up new skills: Slow, Moderate, Fast, Exceptional
    /// </summary>
    [JsonPropertyName("pace")]
    public JobRolePace Pace { get; init; }

    /// <summary>
    /// Routine vs changing tasks: Consistent, SomeChange, Evolving, ConstantChange
    /// </summary>
    [JsonPropertyName("variety")]
    public JobRoleVariety Variety { get; init; }

    /// <summary>
    /// Core characteristics. Exactly three different (unique) values must be selected:
    /// Analytical, Communicative, Decisive, Driven, Emotionally, Resilient, Independent, Innovative, ProcessOriented, Supportive
    /// </summary>
    [JsonPropertyName("characteristics")]
    [MinLength(3)]
    [MaxLength(3)]
    public JobRoleCharacteristic[] Characteristics { get; init; } = Array.Empty<JobRoleCharacteristic>();
}