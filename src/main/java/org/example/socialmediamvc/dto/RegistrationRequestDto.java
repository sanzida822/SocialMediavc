package org.example.socialmediamvc.dto;

public class RegistrationRequestDto {

        private String username;
        private String email;
        private String password;
        private String confirmPassword;
        private ImageDto imageDto;
//	private Part profileImagePart;
//	private byte[] profileImage;

        public RegistrationRequestDto() {}
        public RegistrationRequestDto(String username, String email, String password, String confirmPassword,
                                      ImageDto imageDto) {
            super();
            this.username = username;
            this.email = email;
            this.password = password;
            this.confirmPassword = confirmPassword;
            this.imageDto=imageDto;

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
        public ImageDto getImageDto() {
            return imageDto;
        }
        public void setImageDto(ImageDto imageDto) {
            this.imageDto = imageDto;
        }
        @Override
        public String toString() {
            return "RegistrationRequestDTO [username=" + username + ", email=" + email + ", password=" + password
                    + ", confirmPassword=" + confirmPassword + ", imageDto=" + imageDto + "]";
        }




    }


