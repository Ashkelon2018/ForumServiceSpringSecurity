package telran.ashkelon2018.forum.api;



public interface ForumEndPoint {
	String ACCOUNT = "/account"; //PUT-OWNER, GET - auth, 
	String ACCOUNT_ID = "/account/{id}"; //DELETE OWNER, ADMIN MODERATOR
	String ACCOUNT_ROLE = "/account/role"; //DELETE PUT, ADMIN
	String ACCOUNT_PASSWORD = "/account/password"; //PUT OWNER
	String FORUM_POST = "/forum/post"; //POST - auth, PUT - OWNER
	String FORUM_POSTS = "/forum/posts"; 
	

}
