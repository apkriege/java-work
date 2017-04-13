class StudData {
    
    public:    
        void setID(int);   
        void setName(string);  
        void setEng101(float);    
        void setHist201(float);   
        int  getID () const;   
        string getName() const;   
        float getEng101() const;  
        float getHist201() const;   
        float showGPA();
    
    private:
        int _id;                     // student number  
        string _name;                // student name;  
        float _eng101;               // English score    
        float _hist201;              // History score 
       
};

/**
* This methods sets the students id
* @param id  First param is student id
*/
void StudData::setID(int id) {   _id = id; }

/**
* This methods sets the students name
* @param name  First param is students name
*/
void StudData::setName(string name) {   _name = name; }

/**
* This methods sets the English score
* @param score  First param English score
*/
void StudData::setEng101(float score) {   _eng101 = score; } 

/**
* This methods sets the hisotry score
* @param score  First param is history score
*/
void StudData::setHist201(float score) {   _hist201 = score; } 

int StudData::getID() const {   return _id; } 
string StudData::getName() const {   return _name; } 
float StudData::getEng101() const {   return _eng101; } 
float StudData::getHist201() const {   return _hist201; }