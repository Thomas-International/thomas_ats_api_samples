namespace Thomas.Ats.Api.Client.Model;

/// <summary>
///  Learning required
/// </summary>
public enum JobRoleLearning : byte
{
    /// <summary>
    /// None
    /// </summary>
    None = 1,

    /// <summary>
    /// Initial
    /// </summary>
    Initial = 2,

    /// <summary>
    /// Ongoing
    /// </summary>
    Ongoing = 3,

    /// <summary>
    /// Constant
    /// </summary>
    Constant = 4
}