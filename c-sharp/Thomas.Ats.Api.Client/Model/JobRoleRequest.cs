using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
/// Object representing a Job Role request
/// </summary>
public class JobRoleRequest
{   
    /// <summary>
    /// Title of the Job Role
    /// </summary>
    [JsonPropertyName("title")]
    [MaxLength(100)]
    [Required]
    public string? Title { get; set; }

    /// <summary>
    /// Longer description of the role, including any necessary criteria
    /// </summary>
    [JsonPropertyName("description")]
    public string? Description { get; set; } = string.Empty;
    
    /// <summary>
    /// Amount of experience required: EntryLevel, Graduate, Experienced, Management
    /// </summary>
    [JsonPropertyName("level")]
    [Required]
    public JobRoleLevel Level { get; set; }
    
    /// <summary>
    /// Learning required: EntryLevel, Graduate, Experienced, Management
    /// </summary>
    [JsonPropertyName("learning")]
    [Required]
    public JobRoleLearning Learning { get; set; }
    
    /// <summary>
    /// Time available to pick up new skills: Slow, Moderate, Fast, Exceptional
    /// </summary>
    [JsonPropertyName("pace")]
    [Required]
    public JobRolePace Pace { get; set; }
    
    /// <summary>
    /// Routine vs changing tasks: Consistent, SomeChange, Evolving, ConstantChange
    /// </summary>
    [JsonPropertyName("variety")]
    [Required]
    public JobRoleVariety Variety { get; set; }
    
    /// <summary>
    /// Core characteristics. Exactly three different values must be selected:
    /// Analytical, Communicative, Decisive, Driven, Emotionally, Resilient, Independent, Innovative, ProcessOriented, Supportive
    /// </summary>
    [JsonPropertyName("characteristics")]
    [Required]
    [MinLength(3)]
    [MaxLength(3)]
    public JobRoleCharacteristic[]? Characteristics { get; set; }
}