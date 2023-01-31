using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Thomas.Ats.Api.Client.Model;

/// <summary>
///  Object representing Star Ratings for the candidate's suitability for this role
/// </summary>
public class StarRatings
{
    /// <summary>
    /// Overall candidate star rating
    /// </summary>
    [JsonPropertyName("overallStarRating")]
    [Range(0, 5)]
    public double OverallStarRating { get; set; }
    
    /// <summary>
    /// The behaviour rating provides information around how a person prefers to behave at work and the characteristics they will demonstrate,
    /// communication style, what motivates them and an insight into their strengths, areas for development and value to the organisation
    /// </summary>
    [JsonPropertyName("aptitudeStarRating")]
    [Range(0, 5)]
    public double AptitudeStarRating { get; set; }
    
    /// <summary>
    /// The aptitude rating indicates a person's fluid intelligence i.e. how quickly they will learn and retain new skills and procedures and how quickly
    /// they can grasp a new role. It looks at an individual's speed of processing information and ability to learn and develop new skills and is used for
    /// a variety of purposes: recruitment, retention, development, management, identifying training needs, career guidance, succession planning and benchmarking
    /// </summary>
    [JsonPropertyName("behaviourStarRating")]
    [Range(0, 5)]
    public double BehaviourStarRating { get; set; }

    /// <summary>
    /// The personality rating gives you insight into the underlying traits that drive how a person works and interacts with those around them.
    /// A personality trait is an enduring characteristic of a person and describes a person’s desire for success, their reaction to stress,
    /// their preference for novelty, their approach to risk, their tolerance of uncertainty and their desire for power and influence
    /// </summary>
    [JsonPropertyName("personalityStarRating")]
    [Range(0, 5)]
    public double PersonalityStarRating { get; set; }
}