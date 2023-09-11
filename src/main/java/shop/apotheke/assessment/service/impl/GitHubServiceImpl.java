package shop.apotheke.assessment.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import shop.apotheke.assessment.exception.ShopApothekeException;
import shop.apotheke.assessment.model.GitHubBo;
import shop.apotheke.assessment.model.ItemBo;
import shop.apotheke.assessment.service.GitHubService;
import shop.apotheke.assessment.util.Constants;

@Service
public class GitHubServiceImpl implements GitHubService {

	@Value("${gitHubApi.path}")
	private String gitHubApiPath;

	private final RestTemplate restTemplate = new RestTemplate();
	private final Logger logger = LoggerFactory.getLogger(GitHubServiceImpl.class);

	@Override
	public GitHubBo fetchPopularRepositories(int limit, LocalDate date, String language) {
		String url = String.format(gitHubApiPath, date);

		if (language != null && !language.isEmpty()) {
			url.concat(Constants.LANGUAGE + language);
		}

		url.concat(Constants.SORT_AND_ORDER);

		logger.info(url);
		
		try {

			ResponseEntity<GitHubBo> response = restTemplate.getForEntity(url, GitHubBo.class);
			GitHubBo apiResponse = response.getBody();

			if (apiResponse != null) {
				List<ItemBo> items = apiResponse
						.getItems()
						.stream()
						.limit(limit)
						.collect(Collectors.toList());
				apiResponse.setItems(items);
				
				logger.info(Constants.FETCH_SUCCESSFUL);
				return apiResponse;
				
			} else {
				logger.error(Constants.NO_RESPONSE);
				throw new ShopApothekeException(Constants.NO_RESPONSE);
			}
			
		} catch (Exception ex) {
			logger.error(Constants.FETCH_UNSUCCESSFUL, ex);
			throw new ShopApothekeException(Constants.FETCH_UNSUCCESSFUL, ex);
		}
	}
}
