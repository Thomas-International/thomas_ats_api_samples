namespace Thomas.Ats.Api.Client.Model;

/// <summary>
///  Routine vs changing tasks
/// </summary>
public enum JobRoleVariety : byte
{
    /// <summary>
    /// Consistent
    /// </summary>
    Consistent = 1,

    /// <summary>
    /// Some change
    /// </summary>
    SomeChange = 2,

    /// <summary>
    /// Evolving
    /// </summary>
    Evolving = 3,

    /// <summary>
    /// Constant change
    /// </summary>
    ConstantChange = 4
}