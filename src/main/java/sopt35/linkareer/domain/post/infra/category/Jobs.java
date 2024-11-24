package sopt35.linkareer.domain.post.infra.category;

import java.util.Arrays;
import java.util.List;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.global.exception.LinkareerException;

public enum Jobs {
    DESIGN(Arrays.asList(Job.DESIGN, Job.PRODUCT_DESIGN, Job.UX_UI));

    private final List<Job> job;

    Jobs(List<Job> job) {
        this.job = job;
    }

    public static List<String> getJobNamesRelateWith(final String jobName) {
        Job relateJob = Job.findJobByName(jobName);
        Jobs relateJobs = Arrays.stream(Jobs.values())
                .filter(jobs -> jobs.getJob().contains(relateJob))
                .findFirst()
                .orElseThrow(
                        () -> new LinkareerException(ErrorCode.CATEGORY_NOT_FOUND)
                );

        return relateJobs.getJob().stream()
                .map(Job::getName)
                .toList();
    }

    public List<Job> getJob() {
        return job;
    }
}
