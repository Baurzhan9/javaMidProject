//package main.service;
//
//
//import main.entity.answer;
//import main.entity.exam;
//import main.entity.question;
//import main.repository.AnswerRepository;
//import main.repository.ExamRepository;
//import main.repository.QuestionRepository;
//import org.aspectj.weaver.patterns.TypePatternQuestions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Random;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class ExamService {
//    public static final double MAX_GRADE = 100; // 100 points
//
//    @Autowired
//    private ExamRepository examRepo;
//
//    @Autowired
//    private QuestionRepository questionRepo;
//
//    @Autowired
//    private AnswerRepository answerRepo;
//
//    @Autowired
//    private ExamRepository protocolRepo;
//
//    public exam getRandomExam() {
//        final int examCount = (int) examRepo.count();
//        assert examCount > 0;
//        final int examNumber = new Random().nextInt(examCount);
//        return examRepo.findAll().get(examNumber);
//    }
//
//    @Transactional
//    public Long insertExam(exam protocol) {
//        final exam p = protocolRepo.save(protocol);
//        protocolRepo.flush();
//        return protocol.getId();
//    }
//
//    @Transactional
//    public exam updateExamProtocol(exam protocol) {
//        return protocolRepo.save(protocol);
//    }
//
////    public exam getExam(int examId) {
////        final exam exam = examRepo.findOne(examId);
////        return exam;
////    }
////
////    public exam getExamProtocol(int protocolId) {
////        return protocolRepo.findOne(protocolId);
////    }
//
//
//    public List<question> getQuestionsForExam(int examId) {
//        final List<question> questions = questionRepo.findByExamId(examId);
//        return questions;
//    }
//
//    public List<answer> getAnswersForQuestion(int questionId) {
//        final List<answer> answers = answerRepo.findByQuestionId(questionId);
//        return answers;
//    }
//
//    public question getNextQuestion(exam exam, Set<Integer> ids) {
//        final Set<Integer> identificators = new HashSet<>(ids);
//        if (identificators.size() == 0) {
//            identificators.add(0); // add to avoid null
//        }
//        return questionRepo.findFirstByExamAndIdNotIn(exam, identificators);
//    }
//
//    /**
//     * Process grade user answer on some question
//     *
//     * @param protocol user exam protocol
//     * @param examId exam ID
//     * @param userAnswers user answers as array of answer IDs
//     */
//    public void calcGrade(exam protocol, int examId, List<Integer> userAnswers) {
//        if (protocol == null || userAnswers == null) {
//            throw new IllegalArgumentException("Invalid parameters on GRADE call");
//        }
//
//        final List<answer> correctAnswers = answerRepo.findByQuestionExamIdAndCorrect(examId, true);
//        if (correctAnswers.size() == 0) {
//            throw new IllegalArgumentException("You must specify correct answers!");
//        }
//
//        final float step = (float) (MAX_GRADE / correctAnswers.size());
//        final Set<Integer> correctCount = new HashSet<>();
//        final Set<Integer> incorrectCount = new HashSet<>();
//
//        final Set<Integer> answers = userAnswers.stream().filter(a -> a > 0).collect(Collectors.toSet());
//
//        float grade = 0;
//        for (final answer answer : correctAnswers) {
//            final Long id = answer.getId();
//            if (answers.contains(id)) {
//                grade += step;
//                correctCount.add(Math.toIntExact(id));
//            } else {
//                incorrectCount.add(Math.toIntExact(id));
//            }
//        }
//        // fix for multi-answers questions
//        correctCount.removeAll(incorrectCount);
//
//        // grade
////        protocol.setCorrectAnswers(correctCount.size());
////        protocol.setGrade(Math.round(grade));
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(ExamService.class);
//
//}
