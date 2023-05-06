package hallym.hashtag.global.config.jwt;

public interface JwtProperties {
    String SECRET = "sosow0212";
    int EXPIRATION_TIME = 60000 * 10; // 10분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";

}
