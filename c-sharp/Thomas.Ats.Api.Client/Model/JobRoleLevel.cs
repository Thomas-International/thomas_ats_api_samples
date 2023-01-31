namespace Thomas.Ats.Api.Client.Model;

/// <summary>
///  Amount of experience required
/// </summary>
public enum JobRoleLevel : byte
{
    /// <summary>
    /// Entry level
    /// </summary>
    EntryLevel = 1,

    /// <summary>
    /// Graduate level
    /// </summary>
    Graduate = 2,

    /// <summary>
    /// Experienced level
    /// </summary>
    Experienced = 3,

    /// <summary>
    /// Management level
    /// </summary>
    Management = 4
}