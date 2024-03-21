package helllo.hellospring;

import helllo.hellospring.aop.TimeTraceAop;
import helllo.hellospring.repository.*;
import helllo.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    private EntityManager entityManager;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(
            DataSource dataSource,
            EntityManager entityManager,
            MemberRepository memberRepository
    ) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //    @Bean
//    public JdbcMemberRepository memoryMemberRepository() {
//        // return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(entityManager);
//        }
//    }

}
