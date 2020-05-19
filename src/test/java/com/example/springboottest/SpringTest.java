package com.example.springboottest;

import com.example.springboottest.model.taskRule;
import com.example.springboottest.service.NewService;
import com.example.springboottest.service.impl.NewServiceImpl;
import com.example.springboottest.util.CSVUtil;
import com.example.springboottest.util.StringUtil;
import com.example.springboottest.util.txtExport;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringTest {


    @Autowired
    private NewService newService;
    // 读CSV 文件内容并 写入到txt文件中

    @Test
    public void test1()throws Exception{

        String path = "D:/news_over.csv";
        CSVUtil.readCSVWriteTxt(path);
//        CSVUtil.readCSV(path);
        System.out.println("===========执行完成==============");
    }

    @Test
    public void test2()throws Exception{

//        String str = "&#13;           2017年5月6日1时14分，我国自动控制技术专家、中国工程院院士、交通大学1941级电机工程系学长、2011年度上海交通大学“杰出校友卓越成就奖”获得者屠善澄因病医治无效，不幸去世，享年94岁。 ?&#13;&#13;屠善澄，我国人造卫星工程开拓者之一，中国自动化学会的创建人之一。1923年8月12日出生于浙江嘉兴，1941年进入交通大学就读，1945年毕业于上海大同大学电机工程系。1948年月，屠善澄赴美国康奈尔大学电气工程系学习，并于1951年和1953年分别获得硕士、博士学位。1956年回国后，长期从事导弹、卫星、载人飞船控制系统的研究、设计工作。为“东方红二号”试验通信卫星研制与发射试验做出了突出贡献。为促进我国自动化科学技术的交流与发展和国际间的友好往来做出了重要贡献。1988年1月后任中国空间技术研究院科技委主任，国防科工委科技委兼职副主任。多次主持、参与自动控制工程技术重大问题的讨论决定，是中国工程院院士、国际宇航科学院院士、国际自动控制联合会（IFAC）理论专业委员会和空间专业委员会委员。长期担任兼职教授、博士生导师，培养了许多自动控制科技人才。1997年获何梁何利基金科学与技术进步奖。1991年被航空航天部评为有突出贡献的老专家。 ?&#13;学在交大 科研报国&#13;1923年，屠善澄出生在浙江嘉兴的一个家庭，由于祖父的思想守旧，造成了父亲未能完成学业的遗憾，也让父亲产生了让家里每一个子女都上大学的想法。抗日战争爆发后，屠善澄举家迁往上海，他的童年和少年经历了抗战、沦陷和逃难，打上了深深的时代烙印。 ?&#13;1941年，屠善澄考入国立交通大学电机工程系。年底，太平洋战争爆发，日军占领租界，不久，汪伪政府接管国立交通大学（上海本部），“我在上海念书的时候，有一条铁杠，汪精卫的学校我不念。”屠善澄只能另外再找大学，就是私立大同大学，“大同的老师至少百分之七八十是交大老师，他们不愿在汪伪政府的学校教书，来到大同大学，不少学生也跟着跑到大同。”1942年夏，屠善澄离开交大，转入大同电机工程系，考虑毕业后的出路，他选了电力专业。1946年夏，屠善澄回到交大电机工程系任助教，直至1948年1月赴美留学。 ?&#13;在康奈尔大学，屠善澄仍然选择了电力系统为主专业，以自动控制和应用数学为副业。1949年夏，他在美国尼亚加拉——莫霍克电力公司的电网继电保护部做暑假工，接触了电力系统的稳定性问题。从此，他对电力系统和复杂大系统的动力学分析以及它们的控制问题产生浓厚兴趣，并成为他的终身专业。 ?&#13;与此同时，屠善澄也遇到了他的终身伴侣——出生在湖南的湖北姑娘桂湘云，一个书香门第的大家闺秀，是他数学系的学妹。他们的小儿子叫“怀祖”，他出生时，屠善澄和夫人还在美国，正在为回国做准备。“‘怀祖’意思就是怀念祖国。为什么要回国？我一直想回国，没有什么道理，要唱高调那就是爱国吧。” ?&#13;&#13;1956年，刚过而立之年的屠善澄放弃康奈尔大学的高薪，带着妻儿，满怀报国的雄心壮志，回到阔别8年的祖国，并立即投身于祖国的科学事业。 ?&#13;回国后，正值国家制定12年科学发展规划。原本打算把教学当成一生事业的屠善澄，毅然选择了正处于筹备阶段的中科院自动化研究所，并参与了生产过程自动化和计算技术专业筹备组的工作。 ?&#13;当时，我国计算机水平很低，无法满足实验项目的需要，屠善澄带领科技人员对国产电子管及极化继电器等元器件做了大量测试、筛选等工作，在此基础上研制出DMZ-2，DMZ-4电子模拟计算机，满足了我国当时电子模拟计算机的需求，为后来的多种电子模拟计算机包括J331巨型机的研制奠定了技术基础。 ?&#13;空间技术 功绩卓著&#13;1958年，在屠善澄几十年的科研生涯中，是具有转折意义的。在那一年，前苏联发射了第一颗人造卫星，开创了人类征服宇宙的新纪元。同年5月，在武昌召开的中共八大第二次会议上，毛泽东主席提出“我们也要搞自己的人造卫星”。当时，全国科学技术学会联合会要组织各学会去宣传人造卫星，屠善澄代表中国自动化学会参加全国科联召开的各学会负责人会议，在会上凭借自己平时的积累，阐释了他所理解的人造卫星。会议结束时，一位负责同志说：“这位年轻同志讲得不错，大家都能听明白，就让他去讲吧。” ?&#13;从此，“人造卫星”伴随了他的大半生。就是从这一年的11月起，屠善澄开始了对人造地球卫星控制系统的研究。在调查研究的基础上，35岁的屠善澄自学卫星控制技术，编写了《关于人造地球卫星的控制问题》，提出了我国人造地球卫星的控制采用自旋稳定的方式起步，配合喷气或磁控作姿态调整，为后来我国发射的人造地球卫星控制系统提供了参考。抗美援越时期，他还临危受命，参与了导弹的研制工作。 ?&#13;1965年，“651”计划发布，初步确立了卫星方案；1970年，我国第一颗人造卫星“东方红一号”发射成功。作为我国的首颗人造卫星，“东方红一号”要求简单、可靠，采取的是自旋稳定的模式。而之后的“东方红二号”是一颗长寿命应用卫星，控制技术难度增大。屠善澄根据多年的研究成果和丰富的经验，提出了姿态控制方案，并和其他同事一起在解决卫星关键部件等问题上，成功研制出有中国特色的空间润滑系统，奠定了我国在空间润滑方面的研究基础。 ?&#13;此外，屠善澄在参加1984年挽救两颗通信卫星中也做出了重要贡献。在已发射的五颗通信卫星中，控制系统均未出现故障，因而当《试验通信卫星及微波测控系统》获国家级科技进步特等奖时，屠善澄成为控制系统唯一的获奖者。但每每谈及这些成就时，他总是谦虚地表示“航天是集体的智慧，我只是一个见证者和参与者”。 ?&#13;1987年，屠善澄以首席科学家身份参加863计划航天领域专家组，主持航天领域的研究论证工作，和专家们共同勾勒出我国航天事业的总体蓝图，提出我国发展载人航天“三步走”，亲自起草了综合报告中的《国外载人航天的发展道路和趋向》和《我国航天事业发展的新阶段》两章。1991年，屠善澄在综合报告的基础上发表了《关于发展我国载人航天的意义与作用》一文，提出在处理发展载人航天与应用卫星的关系时，两者应密切结合、相互补充的观点，同时指出载人与无人自动化相结合开发利用空间是今后的发展方向，为载人航天的技术发展、经济可行性论证和最终确立载人飞船项目提供了极其重要的依据。 ?&#13;“863计划”的发起人之一杨嘉墀院士曾这样评价：“最后定下来的这个飞船方案，当然不是他（屠善澄）一个人定的，但是他作为专家委员会的首席科学家，最后拍板，功不可没。” ?&#13;育才树人 德厚流光&#13;在对待工作上，屠善澄坦陈从来没有畏难。“事情都是人做的，在科研上我从来不畏难。你想都已经有人第一个提出要搞卫星了，我们跟在后面的人还有什么好怕的！”80多岁时，工作仍是老科学家屠善澄生活中最大的乐趣，他每天上班，走路、慢跑，活动一两个小时，甚至“两三年前还天天洗冷水澡”。 ?&#13;诲人不倦的屠善澄，长期担任中国科学技术大学、哈尔滨工业大学、北京航空航天大学的兼职教授，在教学中数理推导严谨，表述精炼透彻，要求学生严格，深得学生欢迎。特别是担任中国科技大学自动化系运动物体自动控制专业兼职教授时，在百忙中亲自编写《飞行体自动控制》讲义，它是我国有关飞行体自动控制最早的教材之一。提及他的学生，屠善澄非常自豪。“年轻人做得好时我就更高兴，青出于蓝而胜于蓝才是历史发展的规律。”他培养的本科生、研究生和博士生，不少已经是自动化科技领域的工作骨干，或某一方面的学术带头人。 ?&#13;飞天是中华民族几千年来的梦想，而屠善澄从预先研究曙光号飞船到作为“863计划”的第一批首席科学家，不仅见证了飞天梦一步一步的走向现实，而且也为我国载人航天事业奉献出了毕生的心血。他一直认为自己是一个很平凡的人，人生唯一的抱负就是为人类、为国家做些好事情，并且要求自己做的每一件事情都在道义上讲得通。从他身后那一步步坚实的脚印中，我们也渐渐读懂了他那平凡而又不平凡的人生。 ?&#13;参考资料：&#13;廖芳芳，《平凡中写下不平凡的历史——访中国工程院院士屠善澄》； ?&#13;中国自动化学会，《“口述历史”系列访谈（二）》； ?&#13;陈苏，《屠善澄：人造卫星伴随我大半生》； ?&#13;潘聪平、王桂荣，《中国人造卫星的拓荒者——访著名自动控制专家、浙江籍院士屠善澄》。 ?&#13; ?&#13;&#13;&#13;       ";
        String str ="王红阳：治疗恶性肿瘤须＂私人订制＂\n" +
                "来源：中国科学报记者：赵广立时间：2014-11-04\n" +
                " \n" +
                "\n" +
                "王红阳\n" +
                " \n" +
                "    “在我国不断增加肿瘤防治研究经费的情况下，我国的肿瘤发病率仍在快速上升，每分钟就有6个人被诊断为恶性肿瘤。”在日前于深圳举行的2014国际BT（Biotechnology）领袖峰会上，肿瘤分子生物学和肝脏病专家、中国工程院院士王红阳表示，恶性肿瘤的治疗需要“私人订制”。\n" +
                " \n" +
                "    目前，恶性肿瘤的救治消耗了大量的卫生资源。在王红阳看来，尽管对肿瘤的研究取得了诸多进展，但在恶性肿瘤防治方面还存在很大问题，特别是恶性肿瘤病人的远期生存率方面。“这跟人们对肿瘤的认识分不开。18世纪大家认为肿瘤只是单一器官的疾病；到19世纪人们理解了恶性肿瘤是分子、细胞的疾病；直到21世纪人们才真正认识到恶性肿瘤是全身系统性的复杂疾病。用单一因素来解释一个复杂疾病，不可能准确，也不可能根治恶性肿瘤。”\n" +
                " \n" +
                "    “既然恶性肿瘤是一种非常复杂的疾病，而且它们有较长期的发展进程和不同的分类分期，这就需要有真正的标准来确诊和针对性的方法来治疗。”王红阳口中的“真正的标准和针对性的方法”就是个性化医疗。\n" +
                " \n" +
                "    个性化医疗的基础是深刻地理解不同的发病原因和分子机制，即个性化的渊源（“病灶”）。例如，同样是肝癌多发国家，我国和日本有着显著区别。肝癌在我国是致死率排名第二的恶性肿瘤，我国肝癌患者85%以上有乙肝病毒感染病史；日本肝癌病人则大部分是由丙型病毒性肝炎导致的肝癌。这其中的原因尚待探究。\n" +
                " \n" +
                "    王红阳还介绍说，肝癌是所有癌症中对化疗最不敏感的，由于缺乏特效药，手术切除仍是肝癌治疗的首选。“我们医院每天有40~50台肝切除手术，是全世界肝病手术最集中的医院，但实际上我们还远远无法解决肝癌的问题。”王红阳指的正是个性化医疗的基础问题，“就是说，我们现在还没有完全揭示异质性极高的肝癌的发病机制、分子分型和复发转移机理。”\n" +
                " \n" +
                "    在王红阳看来，“私人订制”的个性化治疗才是未来根治恶性肿瘤的方向。“肝癌之所以病死率高，是因为无法实现早期预测和诊断，而其不同的病因和诱因都决定了肝癌极高的异质性和复杂性。针对这样复杂的疾病，诊断标志物就不能是‘一个’而是‘一群’，治疗就一定不能单一化，而一定要针对每个病人不同的遗传背景、不同的诱因和可能完全不同的基因突变，在各种不同的情况下个性化处理，才能有的放矢，有针对性地解决肝癌的治疗问题。”\n" +
                " \n" +
                "    王红阳介绍说，她们近来的发现很好地解释了为什么抗EGFR的药物治疗肝癌效果差——癌基因的突变、突变癌基因高表达的部位不同都与疗效密切相关，盲目使用就完全失去了靶向性。针对肺癌的研究也揭示了确定癌基因突变的个性化才能实现靶向药物的特异性疗效。\n" +
                " \n" +
                "    “好的药物要能靶向多靶点，好的医生要学会量体裁衣、私人订制。这就是强调个性化的重要性和最大的临床需求。”王红阳认为，当前的任务是用更多的方法去对肝癌做精细的分型、分类和早诊，使每一位病人能够得到最需要的、最有效的个性化治疗。\n";
        String   newStr = StringUtil.removeSpecifiedStr(str);
        System.out.println(">>>>>>>>>>>>>>>old"+str);
        System.out.println(">>>>>>>>>>>>>>>>>>>newStr"+newStr);
        System.out.println("===========执行完成==============");


        // 去掉特殊字符
        String str1 = "aaa??bbb";
        str1 = str1.replaceAll("%3f", "").replaceAll("[?]", "");
        System.err.println(str1);

    }



    /**
     *  从数据库中 读取信息 写入到txt文件中 生成多个文件
     * @throws Exception
     */
    @Test
    public void test3()throws Exception{

        // 从数据库中读数据
        List<taskRule> taskRulesList = newService.findAll();

        //循环list 里面的内容
        for (int i = 0; i <taskRulesList.size() ; i++) {
            taskRule taskRule = taskRulesList.get(i);
            String name = taskRule.getName();
            String content = taskRule.getContent();

            //去掉 html的标签
            String  replaceAllContent = StringUtil.removeHTMLLabel(content);

            // 去掉特殊字符
            String  newStr = StringUtil.removeSpecifiedStr(replaceAllContent);
            //  拼接到一个文件中
            String newContent = name +"\r\n"+newStr;

            // 创建文件， 写入文件中
            txtExport.creatTxtFile(i+1);
            // 写入内容
            txtExport.writeTxtFile(newContent);
        }
    }

}
