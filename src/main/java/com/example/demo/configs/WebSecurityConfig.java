package com.example.demo.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.demo.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		// Và sét đặt PasswordEncoder.
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/", "/index", "/courses", "/detailVideo", "/registerTeacher", "/login")
				.permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Trang chỉ dành cho Giáo viên
		http.authorizeRequests()
				.antMatchers("/helloTeacher", "/coursesForTeacher", "/editCourse**", "/createNewCourse**",
						"/videoCourseListForTeacher**", "/createVideo", "/updateVideo**", "/deleteVideo**", "/makeSchedule**","/createNewReport**")
				.hasRole("TEACHER");

		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		// Trang chỉ dành cho Học viên
		http.authorizeRequests().antMatchers("/courses/**", "/videoCourseList**", "/viewVideo**").hasRole("STUDENT");
		
		// Trang chỉ dành cho Học viên & Giao vien
		http.authorizeRequests().antMatchers("/courses/**", "/videoCourseList**", "/viewVideo**","/infoUser","/editUser").hasAnyRole("STUDENT", "TEACHER");

		// Trang chỉ dành cho Học viên
		// http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/404");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit đăng nhập
				.loginPage("/login")// Map đến trang đăng nhập
				.defaultSuccessUrl("/checkRole")// Trang mặc định sẽ đến khi login thành công
				.failureUrl("/login?error=true")// Thông tin đăng nhập sai
				.usernameParameter("username")// Lấy param username
				.passwordParameter("password")// Lấy param password
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

		// Cấu hình Remember Me.
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}