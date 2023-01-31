# JobRole

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**UUID**](UUID.md) | Job Role ID |  [optional]
**title** | **String** | Title of the Job Role |  [optional]
**description** | **String** | Longer description of the Job Role, including any necessary criteria |  [optional]
**level** | [**JobRoleLevel**](JobRoleLevel.md) |  |  [optional]
**learning** | [**JobRoleLearning**](JobRoleLearning.md) |  |  [optional]
**pace** | [**JobRolePace**](JobRolePace.md) |  |  [optional]
**variety** | [**JobRoleVariety**](JobRoleVariety.md) |  |  [optional]
**characteristics** | [**List&lt;JobRoleCharacteristic&gt;**](JobRoleCharacteristic.md) | Core characteristics. Exactly three different (unique) values must be selected:  Analytical, Communicative, Decisive, Driven, Emotionally, Resilient, Independent, Innovative, ProcessOriented, Supportive |  [optional]
