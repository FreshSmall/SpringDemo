package com.example.spel;

import com.example.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class CompilerDemo {

    public static void main(String[] args) {
        User user=new User();
        //创建配置解析
        SpelParserConfiguration configuration=new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,CompilerDemo.class.getClassLoader());
        //创建解析器
        SpelExpressionParser parser=new SpelExpressionParser(configuration);
        //创建取值上下文
        EvaluationContext context=new StandardEvaluationContext(user);
        //表达式
        String expression="isVipMember('tom')&&isVipMember('jony')";
        //解析表达式
        SpelExpression spelExpression=parser.parseRaw(expression);
        //通过表达式求值
        System.out.println(spelExpression.getValue(context));//第一次调用
        System.out.println(spelExpression.getValue(context));//第二次调用

    }
}
