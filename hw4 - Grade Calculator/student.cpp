/**
* This method reads in the students from the grades.txt
* file and populates them into an array
* @param students  First param is array of students
* @param num  Second param is size of student array
*/
void initialize_std_list(StudData students[], int& num) {   
    ifstream infile;  
    int id;   
    string name;   
    float grade;
    // read items data from an input file   
    infile.open("grades.txt");   
    if (!infile) {     
        cout << "Cannot open the input file!" << endl;    
        exit(1);   
    }
  
    num = 0;  
    infile >> id;                         // priming read
    
    // reads name, and grades of each student in the file and stores in array  
    while(infile) {    
        students[num].setID(id);     
        infile >> name;   
        students[num].setName(name);   
        infile >> grade;  
        students[num].setEng101(grade);    
        infile >> grade;   
        students[num].setHist201(grade);
        num++;   
        infile >> id;
    }
    
    infile.close(); 
    
}

/**
* This method prints the list of students
* @param students  First param is array of students
* @param num  Second param is size of student array
*/
void print_std_list(const StudData students[], int num) {   
    for(int i = 0; i < num; i++) {    
        cout << students[i].getID() << " ";     
        cout << students[i].getName() << " ";   
        cout << students[i].getEng101() << " ";   
        cout << students[i].getHist201() << endl ;  
    } 
}

/**
* This method returns the letters score based on grade
* @param score  First param is the students score
* @return grade  Returns the letter grade
*/
string retGrade(int score){
    string grade;
    
    if(score >= 90){
        grade = "(A)";
    }
    else if(score < 90 && score >= 80){
        grade = "(B)";
    }
    else if(score < 80 && score >= 70){
        grade = "(C)";
    }
    else if(score < 70 && score >= 60){
        grade = "(D)";
    }
    else if(score < 60){
        grade = "(F)";
    }
    else{
        grade = "moron";
    }
 
   return grade;
    
}

/**
* This method calculates and returns the averages of 
* all the students grades
* @param students  First param is array of students
* @param num  Second param is size of student array
* @return arr  Returns array of the students averages
*/
int * getAverage(const StudData students[], int num){
    
    static int arr[2];
    int eTotal = 0;
    int hTotal = 0;
    
    for(int i = 0; i < num; i++) {
        eTotal += students[i].getEng101();
        hTotal += students[i].getHist201();
    }
    
    arr[0] = eTotal/num;
    arr[1] = hTotal/num;
    
    return arr;
}

/**
* This method prints the combined averages of students
* @param students  First param is array of students
* @param num  Second param is size of student array
*/
void print_avg(const StudData students[], int num) {
    printf("\n");
    int * arr;
    string eAvg, hAvg;
    arr = getAverage(students, num);
    eAvg = to_string(arr[0])+retGrade(arr[0]);
    hAvg = to_string(arr[1])+retGrade(arr[1]);
    
    printf("%24s%12s%12s", "Class Average:", eAvg.c_str(), hAvg.c_str());
}

/**
* This method prints a formatted list of students along with 
* their score and letter grade
* @param students  First param is array of students
* @param num  Second param is size of student array
*/
void printStudents(const StudData students[], int num){
    int id, tmp1, tmp2;
    string name, eGrade, hGrade;
    
    printf("%12s%12s%12s%12s \n", "Student Name", "Student ID", "Eng101", "Hist201");
    printf("%12s%12s%12s%12s \n", "------------", "----------", "------", "-------");
    
    for(int i = 0; i < num; i++) {    
        name = students[i].getName();
        tmp1 = students[i].getEng101();
        tmp2 = students[i].getHist201();
        
        eGrade = to_string(tmp1)+retGrade(tmp1);
        hGrade = to_string(tmp2)+retGrade(tmp2);
        
        printf("%12s", name.c_str());
        printf("%12d", students[i].getID());
        printf("%12s", eGrade.c_str());
        printf("%12s", hGrade.c_str());
        printf("\n");
    }
    
}



