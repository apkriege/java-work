 <?php
 
    $this->some();
 
    function some(){
        // $test = [][];
        $test = [
            [1, 1, 1, 2, 2, 2, 4],
            [3, 4, 5, 1, 4, 2, 1],
            [3, 2, 5, 2, 2, 2, 3],
            [3, 9, 1, 1, 1, 6, 4]
        ];

        $test2 = [
            [1, 2, 4, 5],
            [4, 4, 5, 6],
            [4, 5, 9, 6],
            [4, 3, 9, 6]
        ];

        $dp = $this->checkHor($test,3);
        $xt = $this->checkVert($test,3);
        // var_dump($dp);
        // var_dump($xt);
        $t = $this->checkDiag($test2,2);

    }

    // $it = (count($arr[0])-count($arr)+1) + ((count($arr)-1)*2);
    
    for($r = 0; $r < $d; $r++){
            $ct = 1;
            for($c = 0; $c < $d; $c++){
                $curr = $arr[$r][$c];
                // var_dump($c);
                for($i = 0; $i < $match; $i++){
                    // if($r+$i > $d-$r){
                    //     var_dump('test');
                    // }
                    // if($r+$i <= $d-$r && $c+$i < $d-$r){
                        // var_dump($arr[$r+$i][$c+$i]);
                    // }
                }   
                var_dump("expression");

            }
        }

    function checkDiag($arr, $match){
        $it = (count($arr[0])-count($arr)+1) + ((count($arr)-1)*2);
        $d = count($arr);
        //right diag
        for($r = 0; $r < $d; $r++){
            for($c = 0; $c < $d; $c++){
                // var_dump($r+$match.$c+$match);
                if($r+$match-1 <= $match && $c+$match-1 <= $match){
                    for($x = 0; $x <= $match; $x++){
                        // var_dump($r+$x+1.$c+$x+1);
                        if($r+$x+1 < $d && $c+$x+1 < $d){
                            $curr = $arr[$r+$x][$c+$x];
                            $n = $arr[$r+$x+1][$c+$x+1];
                            var_dump($curr.$n);
                        }
                        
                        // 
                        // $curr = $arr[$r][$c];
                        // $n = $arr[$r+$x][$c+$x];
                        // var_dump($curr);
                    }

                    
                }
                // var_dump($c+$match);
                // if($r+$match <= $match && $c+$match <= $match){
                    // var_dump('test');
                // }
                // var_dump($arr[$match])
            }
        }
        // for($r = 0; $r < $d * 2; $r++){
            // $ct = 1;
            // for($c = 0; $c <= $r; $c++){
            //     $t = $r - $c;
            //     if($t < $d && $c < $d){
            //         if($t-1 > -1 && $c+1 < $d){
            //             $curr = $arr[$t][$c];
            //             $n = $arr[$t-1][$c+1];
            //             $curr == $n ? $ct++ : $ct = 1;
            //         }
            //     }
            //     if($ct == $match){
            //         var_dump($t.$c);
            //     }
            // }
        // }
    }

    function checkVert($arr, $match){
        $dp = [];
        for($i = 0; $i < count($arr[0]); $i++){ //row
            $ct = 1;
            for($j = 1; $j < count($arr); $j++){ //col
                $p = $arr[$j-1][$i];
                $c = $arr[$j][$i];
                
                $p == $c ? $ct++ : $ct = 1;

                if($ct == $match){
                    array_push($dp, [$i,$j]);
                }
            }
        }
        return $dp;

    }

    function checkHor($test, $match){
        $datapoint = [];
        for($i = 0; $i < count($test); $i++){ //row
            $ct = 1;
            for($j = 1; $j < count($test[0]); $j++){ //col
                $prev = $test[$i][$j-1];
                $curr = $test[$i][$j];

                $prev == $curr ? $ct++ : $ct = 1;

                if($ct == $match){
                    array_push($datapoint, [$i,$j]);
                }
            }
        }
        return $datapoint;
    }
    
    ?>