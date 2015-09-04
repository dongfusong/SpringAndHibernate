package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ToolUserRepository;

/**
 * Created by Thoughtworks on 15/9/3.
 */
@Service
public class UserService {
    @Autowired
    ToolUserRepository userRepository;


}
