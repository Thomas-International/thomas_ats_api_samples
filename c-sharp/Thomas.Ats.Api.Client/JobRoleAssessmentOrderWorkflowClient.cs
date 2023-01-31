using RestSharp;
using RestSharp.Authenticators;
using RestSharp.Serializers.Json;
using System.Text.Json.Serialization;
using Thomas.Ats.Api.Client.Model;

namespace Thomas.Ats.Api.Client
{
    public class JobRoleAssessmentOrderWorkflowClient : RestClient
    {
        private readonly string _callbackUrl;

        public JobRoleAssessmentOrderWorkflowClient(IHttpClientFactory httpClientFactory, string apiKey, string callbackUrl) : base(httpClientFactory.CreateClient("JobRoleWorkflowClient"))
        {
            Options.BaseUrl = new Uri("https://dev-api.thomas.co/ats-open-api");
            Authenticator = new JwtAuthenticator(apiKey);
            UseSerializer(() => new SystemTextJsonSerializer(new System.Text.Json.JsonSerializerOptions() { Converters = { new JsonStringEnumConverter() } }));
            _callbackUrl = callbackUrl;
        }

        public async Task<RestResponse<JobRole[]>> GetJobRoles()
        {
            RestRequest request = new RestRequest("v1/jobRole");
            request.Method = Method.Get;
            return await this.ExecuteAsync<JobRole[]>(request);
        }

        public async Task<RestResponse<JobRole>> GetJobRole(Guid id)
        {
            RestRequest request = new RestRequest($"v1/jobRole/{id}");
            request.Method = Method.Get;
            return await this.ExecuteAsync<JobRole>(request);
        }

        public async Task<RestResponse<JobRole>> CreateJobRole(JobRoleRequest jobRole)
        {
            RestRequest request = new RestRequest("v1/jobRole");
            request.Method = Method.Post;
            request.AddJsonBody(jobRole);
            return await this.ExecuteAsync<JobRole>(request);
        }

        public async Task<RestResponse<JobRoleAssessmentOrderResult>> CreateJobRoleAssessmentOrder(string emailAddress, Guid roleId)
        {
            RestRequest request = new RestRequest("v1/jobRoleAssessmentOrder");
            request.Method = Method.Post;
            request.AddJsonBody(new JobRoleAssessmentOrderRequest()
            {
                Email = emailAddress,
                RoleId = roleId,
                CallbackUrl = _callbackUrl
            });
            return await this.ExecuteAsync<JobRoleAssessmentOrderResult>(request);
        }

        public async Task<RestResponse<JobRoleAssessmentOrderResult>> GetJobRoleAssessmentOrder(string assessmentOrderId)
        {
            RestRequest request = new RestRequest($"v1/jobRoleAssessmentOrder/{assessmentOrderId}");
            request.Method = Method.Get;
            return await this.ExecuteAsync<JobRoleAssessmentOrderResult>(request);
        }

        public async Task<RestResponse<JobRoleAssessmentOrderResult[]>> GetJobRoleAssessmentOrders(Guid jobRoleId, bool? completeOnly)
        {
            RestRequest request = new RestRequest($"v1/jobRoleAssessmentOrder/");
            request.Parameters.AddParameter(new QueryParameter("jobRoleId", jobRoleId.ToString()));
            if (completeOnly != null)
            {
                request.Parameters.AddParameter(new QueryParameter("complete", completeOnly.ToString()));
            }

            request.Method = Method.Get;
            return await this.ExecuteAsync<JobRoleAssessmentOrderResult[]>(request);
        }
    }
}