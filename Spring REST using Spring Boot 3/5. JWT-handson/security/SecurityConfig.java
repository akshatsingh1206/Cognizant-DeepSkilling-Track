@Override
protected void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
            .csrf().disable()
            .httpBasic()
            .and()

            .authorizeRequests()

            .antMatchers("/authenticate")
            .hasAnyRole("USER", "ADMIN")

            .anyRequest()
            .authenticated()

            .and()

            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
}