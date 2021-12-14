package com.example.foodorderingapplication.services.User;


import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.db.repository.UserRepository;
import com.example.foodorderingapplication.dto.restaurant.RegisterDetails;
import com.example.foodorderingapplication.dto.user.UserLoginCredentials;
import com.example.foodorderingapplication.dto.user.UserProfile;
import com.example.foodorderingapplication.exceptions.EmailAlreadyExistsException;
import com.example.foodorderingapplication.exceptions.UserNotFoundException;
import com.example.foodorderingapplication.exceptions.UsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserProfile> getUsers() {
        return userRepository.getallUserProfile();
    }

    @Override
    public Optional<UserProfile> getUser(Long id) {
        Optional<UserProfile> opt = userRepository.getUserProfile(id);
        if(!opt.isPresent())
            opt=Optional.empty();
        return opt;
    }

    @Override
    public User createUser(RegisterDetails registerDetails) {

       checkMail(registerDetails.getEmail());
       checkUsername(registerDetails.getUsername());

       User user = new User();
       user.setUsername(registerDetails.getUsername());
       user.setRole(registerDetails.getRole());
       String hashPassword=bCryptPasswordEncoder.encode(registerDetails.getPassword());
       user.setPasswordHash(hashPassword);
       user.setEmail(registerDetails.getEmail());

       user.setAddress("");
       user.setTasks(Collections.emptyList());
       user.setTransactions(Collections.emptyList());
       user.setOrders(Collections.emptyList());
       user.setOwnedRestaurants(Collections.emptyList());

       User u =userRepository.save(user);

       return u;
    }

    private void checkMail(String email)
    {
        User t = userRepository.findByEmail(email);

        if(t  !=null)
            throw new EmailAlreadyExistsException("email already exists");
    }

    private void checkUsername(String username)
    {
        User t = userRepository.findByEmail(username);

        if(t != null)
            throw new UsernameAlreadyExistsException("username already exists");
    }


    @Override
    public User editUser(UserProfile userProfile) {
        User user =  userRepository.getById(userProfile.getId());

        if(user == null)
            throw new UserNotFoundException();

        User t= userRepository.findByUsername(userProfile.getUsername());
        if(t !=null)
        {
            if(t.getId() != user.getId() )
            {
                throw new UsernameAlreadyExistsException("username already exists to a different user");
            }
        }

        t= userRepository.findByEmail(userProfile.getEmail());
        if(t!=null)
        {
            if(t.getId() !=user.getId())
            {
                throw new EmailAlreadyExistsException("email is used by other user");
            }
        }

        user.setEmail(userProfile.getEmail());
        user.setUsername(userProfile.getUsername());
        user.setAddress(userProfile.getAddress());

        user = userRepository.save(user);

        return user;
    }

    @Override
    public Boolean loginCheck(UserLoginCredentials userLoginCredentials) {

        User u = userRepository.findByUsername(userLoginCredentials.getUsername());
        if(u == null)
            throw new UserNotFoundException();

        if(bCryptPasswordEncoder.matches(userLoginCredentials.getNotHashedPassword(),u.getPasswordHash()))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }
}
