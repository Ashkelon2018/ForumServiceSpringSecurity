package telran.ashkelon2018.forum.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import telran.ashkelon2018.forum.dao.ForumRepository;
import telran.ashkelon2018.forum.dao.UserAccountRepository;
import telran.ashkelon2018.forum.domain.Post;
import telran.ashkelon2018.forum.domain.UserAccount;

@Component
public class WebSecurity {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	ForumRepository forumRepository;
	
	public boolean checkAuthorityForDeletePost(Authentication authentication, String id) {
		Post post = forumRepository.findById(id).orElse(null);
		if (post == null) {
			return false;
		}
		String user = authentication.getName();
		UserAccount userAccount = userAccountRepository.findById(user).get();
		if(userAccount.getRoles().stream().anyMatch(r -> r.contains("MODER") || r.contains("ADMIN"))) {
			return true;
		}
		return post.getAuthor().equals(user);
	}

}
