namespace Thomas.Ats.Api.Client.Model;

/// <summary>
///  Time available to pick up new skills
/// </summary>
public enum JobRolePace : byte
{
    /// <summary>
    /// Slow
    /// </summary>
    Slow = 1,

    /// <summary>
    /// Moderate
    /// </summary>
    Moderate = 2,

    /// <summary>
    /// Fast
    /// </summary>
    Fast = 3,

    /// <summary>
    /// Exceptional
    /// </summary>
    Exceptional = 4
}