package me.prchecker.githubclient;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RepositoryInterface {
    @GET("user/repos")
    Call<List<Repository>> listRepos(@Header("Authorization") String accessToken,
                                     @Header("Accept") String apiVersionSpec);

    @GET("repos/{owner}/{repo}/pulls")
    Call<List<PullRequest>> listPullRequests(
            @Header("Authorization") String accessToken,
            @Header("Accept") String apiVersionSpec,
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @DELETE("repos/{owner}/{repo}")
    Call<DeletePayload> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                                   @Path("repo") String repo, @Path("owner") String owner);

    @POST("repos")
    Call<Repository> createRepo(@Body Repository repo, @Header("Authorization") String accessToken,
                                @Header("Accept") String apiVersionSpec,
                                @Header("Content-Type") String contentType);

//    @POST("{owner}/{repo}/checkpulls")
//    Call<Repository> checkPullRequestNames(
//            @Body
//    );
}