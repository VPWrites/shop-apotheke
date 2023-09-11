package shop.apotheke.assessment.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OwnerBo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 5119864417452498110L;

	private String login;
	private long id;
	private String nodeId;
	private String avatarUrl;
	private String gravatarId;
	private String url;
	private String htmlUrl;
	private String followersUrl;
	private String followingUrl;
	private String gistsUrl;
	private String starredUrl;
	private String subscriptionsUrl;
	private String organizationsUrl;
	private String reposUrl;
	private String eventsUrl;
	private String receivedEventsUrl;
	private String type;
	private boolean siteAdmin;

}
