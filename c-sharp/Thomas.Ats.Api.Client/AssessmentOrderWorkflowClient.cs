using RestSharp;
using RestSharp.Authenticators;
using RestSharp.Serializers.Json;
using System.Text.Json.Serialization;
using Thomas.Ats.Api.Client.Model;

namespace Thomas.Ats.Api.Client
{
    public class AssessmentOrderWorkflowClient : RestClient
    {
        private readonly string _callbackUrl;

        public AssessmentOrderWorkflowClient(IHttpClientFactory httpClientFactory, string apiKey, string callbackUrl) : base(httpClientFactory.CreateClient("JobRoleWorkflowClient"))
        {
            Options.BaseUrl = new Uri("https://dev-api.thomas.co/ats-open-api");
            Authenticator = new JwtAuthenticator(apiKey);
            UseSerializer(() => new SystemTextJsonSerializer(new System.Text.Json.JsonSerializerOptions() { Converters = { new JsonStringEnumConverter() } }));
            _callbackUrl = callbackUrl;
        }

        public async Task<RestResponse<AssessmentOrderResult>> CreateAssessmentOrder(string emailAddress)
        {
            RestRequest request = new RestRequest("v1/assessmentOrder");
            request.Method = Method.Post;
            request.AddJsonBody(new AssessmentOrderRequest()
            {
                Email = emailAddress,
                CallbackUrl = _callbackUrl
            });
            return await this.ExecuteAsync<AssessmentOrderResult>(request);
        }

        public async Task<RestResponse<AssessmentOrderResult>> GetAssessmentOrder(string assessmentOrderId)
        {
            RestRequest request = new RestRequest($"v1/assessmentOrder/{assessmentOrderId}");
            request.Method = Method.Get;
            return await this.ExecuteAsync<AssessmentOrderResult>(request);
        }
    }
}