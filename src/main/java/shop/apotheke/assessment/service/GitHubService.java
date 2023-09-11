package shop.apotheke.assessment.service;

import java.time.LocalDate;

import shop.apotheke.assessment.model.GitHubBo;

public interface GitHubService {

	GitHubBo fetchPopularRepositories(int limit, LocalDate date, String language);
}
