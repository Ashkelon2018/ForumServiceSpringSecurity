package telran.ashkelon2018.forum.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static telran.ashkelon2018.forum.api.ForumEndPoint.*;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.POST, ACCOUNT);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.csrf().disable();
		http.authorizeRequests().antMatchers(FORUM_POSTS+"/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,
				ACCOUNT, FORUM_POST+"/*").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.POST,	
				FORUM_POST).authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.PUT, 
				FORUM_POST+"/*/like").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.PUT, 
				FORUM_POST+"/*/comment").authenticated();
		http.authorizeRequests().antMatchers(ACCOUNT_ROLE+"/**").hasRole("ADMIN");
		
//		String ACCOUNT = "/account"; //PUT-OWNER 
//		String ACCOUNT_ID = "/account/{id}"; //DELETE OWNER, ADMIN MODERATOR
//		String ACCOUNT_ROLE = "/account/role/{id}/{role}";
//		String ACCOUNT_PASSWORD = "/account/password"; //PUT OWNER
//		String FORUM_POST = "/forum/post"; PUT - OWNER
//		String FORUM_POST_ID = "/forum/post/{id}";  DELETE - OWNER ADMIN MODERATOR
//		String FORUM_POST_LIKE ="/forum/post/{id}/like"; 
//		String FORUM_POST_COMMENT ="/forum/post/{id}/comment";
//		String FORUM_POSTS = "/forum/posts"; 
		
	}
}


