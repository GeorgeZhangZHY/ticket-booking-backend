package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.UserServ;
import edu.nju.ticketbooking.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserServ {

    @Autowired
    private UserDao userDao;

    /**
     * 二阶等差
     * 100分2级 300分3级 600分4级 1000分5级，以此类推，最高11级（即5500分）
     */
    private int calcUserLevel(double accumulatedScore) {
        if (accumulatedScore >= 5500) {
            return 11;
        }
        return 1 + (int) (Math.sqrt(8 * (accumulatedScore / 100) + 1) - 1) / 2;
    }

    private String getActivateHtml(int userId) {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>")
                .append("<body>")
                .append(String.format("<a target='_blank' href='http://localhost:8080/activate?userId=%d'>", userId))
                .append("点击激活您的在线订票系统账号")
                .append("</a>")
                .append("</body>")
                .append("</html>");
        return builder.toString();
    }

    @Override
    public User getUser(int userId) {
        User user = userDao.getUser(userId);
        return user != null && user.getIsActivated() ? user : null;
    }

    @Override
    public User login(String email, String password) {
        // todo
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        User user = userDao.getUser(userId);
        user.setDeleted(true);
        userDao.modifyUser(user);
    }

    @Override
    public void activateUser(int userId) {
        User user = userDao.getUser(userId);
        user.setActivated(true);
        userDao.modifyUser(user);
    }

    @Override
    public User modifyUser(User modifiedUser) {
        return userDao.modifyUser(modifiedUser);
    }

    @Override
    public User applyForNewUser(User newUser) {
        User savedUser = userDao.addNewUser(newUser);
        String mailTo = savedUser.getEmail();
        String htmlContent = getActivateHtml(savedUser.getId());
        String subject = "在线订票系统账号激活";
        EmailUtil.sendMail(mailTo, subject, htmlContent);
        return savedUser;
    }

    @Override
    public boolean modifyScore(int userId, double scoreDelta, boolean accumulated) {
        User user = userDao.getUser(userId);
        double nextScore = user.getScore() + scoreDelta;
        if (nextScore < 0) {
            return false;
        }
        user.setScore(nextScore);
        if (accumulated) {
            user.setAccumulatedScore(user.getAccumulatedScore() + scoreDelta);
            user.setLevel(calcUserLevel(user.getAccumulatedScore()));
        }
        userDao.modifyUser(user);
        return true;
    }

    @Override
    public boolean modifyBalance(int userId, double balanceDelta) {
        User user = userDao.getUser(userId);
        double nextBalance = user.getBalance() + balanceDelta;
        if (nextBalance < 0) {
            return false;
        }
        user.setBalance(nextBalance);
        userDao.modifyUser(user);
        return true;
    }

    @Override
    public double getUserLevelDiscount(int userId) {
        User user = userDao.getUser(userId);
        int userLevel = user.getLevel();
        double discountIncrement = 0.03;
        return 1.0 - (userLevel - 1) * discountIncrement;
    }
}
