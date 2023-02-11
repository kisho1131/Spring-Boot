package com.graphql.sk.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class TestResolver implements GraphQLQueryResolver {

    public String testBankQuery(){
        return "Testing the Application with Bank Query";
    }
}
