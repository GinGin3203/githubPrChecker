package me.prchecker.githubclient;

import org.eclipse.egit.github.core.PullRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VerifierExecutor {
    String pattern = "^(GENERATOR|LEETCODE)\\s(1021|1022|1013|2021|2022)" +
            "\\s(Added|Deleted|Refactored|Moved|Fixed).+";

    public boolean isCorrect(@NotNull PullRequest pr) {
        return (pattern.matches(pr.getTitle()));
    }

    @Scheduled(cron = "* * * ? * * ")
    public void print() {
        System.out.println("I'm VerifierExecutor");
    }
}
