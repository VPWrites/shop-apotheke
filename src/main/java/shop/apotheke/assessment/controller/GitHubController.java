package shop.apotheke.assessment.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.apotheke.assessment.model.GitHubBo;
import shop.apotheke.assessment.service.GitHubService;

@RestController
@RequestMapping("/github")
public class GitHubController {

	@Autowired
	private GitHubService gitHubService;

	private static final Logger logger = LoggerFactory.getLogger(GitHubController.class);

	@GetMapping("/popularRepositories")
	public GitHubBo fetchPopularRepositories(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, 
			@RequestParam(required = false) String language,
			@RequestParam(defaultValue = "1") int limit) {
		
		GitHubBo repositories = gitHubService.fetchPopularRepositories(limit, date, language);
		
		logger.info("Returning {} popular repository(ies).", repositories.getItems().size());
		
		return repositories;
	}
}
