package me.prchecker.githubclient;

import org.eclipse.egit.github.core.PullRequest;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GitHubClientController {
    private final GitHubService githubService;

    public GitHubClientController(GitHubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repos")
    public List<Repository> getRepos() throws IOException {
        return githubService.getRepositories();
    }

    @GetMapping("/repos/{owner}/{repo}/pulls")
    public List<PullRequest> getPullRequests(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName
    ) throws IOException {
        return githubService.getPullRequests(owner, repoName);
    }

    @PostMapping("/repos")
    public Repository createRepo(@RequestBody Repository newRepo) throws IOException {
        return githubService.createRepository(newRepo);
    }

    @DeleteMapping("/repos/{owner}/{repo}")
    public DeletePayload deleteRepo(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName) throws IOException {
        return githubService.deleteRepository(owner, repoName);
    }

}
